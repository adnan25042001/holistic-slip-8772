package com.masai.srv;

import java.util.List;
import java.util.Scanner;

import com.masai.beans.Bidder;
import com.masai.beans.Tender;
import com.masai.beans.Vendor;
import com.masai.dao.BidderDao;
import com.masai.dao.BidderDaoImpl;
import com.masai.dao.TenderDao;
import com.masai.dao.TenderDaoImpl;
import com.masai.dao.VendorDao;
import com.masai.dao.VendorDaoImpl;

public class VendorUser extends User {

	public VendorUser() {
		super();
	}

	public VendorUser(String username, String password) {
		super(username, password);
	}

	public boolean loginVendor() {

		VendorDao vdao = new VendorDaoImpl();

		if (vdao.validatePassword(getUsername(), getPassword())) {
			System.out.println("Login Succesfull");
			return true;
		} else {
			System.out.println("Login Denied! Invalid User Details");
			return false;
		}
	}

	public void updateProfile() {

		Scanner sc = new Scanner(System.in);

		Vendor vendor = new Vendor(this.getUsername(), this.getPassword());

		System.out.println("Enter Vender Details:");
		System.out.println("Name:");
		vendor.setVname(sc.nextLine());

		System.out.println("Email:");
		vendor.setVemail(sc.nextLine());

		System.out.println("Company:");
		vendor.setCompany(sc.nextLine());

		System.out.println("Mobile:");
		vendor.setVmob(sc.nextLine());

		System.out.println("Address");
		vendor.setAddress(sc.nextLine());

		VendorDao vdao = new VendorDaoImpl();

		String status = vdao.updateProfile(vendor);

		System.out.println(status);
	}

	public void viewAllTendors() {

		TenderDao tdao = new TenderDaoImpl();

		List<Tender> tenders = tdao.getAllTenders();

		if (tenders.isEmpty())
			System.out.println("No Tenders Found");
		else {
			int count = 1;
			for (int i = 0; i < tenders.size(); i++) {
				Tender t = tenders.get(i);
				System.out.println(count + " Tender Details:");
				System.out.println("ID " + t.getTid());
				System.out.println("Title " + t.getTname());
				System.out.println("Price " + t.getTprice());
				System.out.println("Type " + t.getTtype());
				System.out.println("Description " + t.getTdesc());
				System.out.println("=================================");

				count++;
			}
		}

	}

	public void bidTender() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the Tender Id:");
		String tid = sc.nextLine();

		System.out.println("Enter Bid Amount");
		int bidAmount = Integer.parseInt(sc.nextLine());

		System.out.println("Enter Bid Id");
		String bidId = sc.nextLine();

		BidderDao bdao = new BidderDaoImpl();

		String status = bdao.bidTender(tid, this.getUsername(), bidAmount, bidId);

		System.out.println(status);

	}

	public void getAllBidsOfaVendor() {

		BidderDao bdao = new BidderDaoImpl();

		List<Bidder> bids = bdao.getAllBidsOfaVendor(this.getUsername());

		if (bids.isEmpty()) {
			System.out.println("No Bids Found");
		} else {
			int count = 1;
			for (int i = 0; i < bids.size(); i++) {
				Bidder b = bids.get(i);
				System.out.println(count + " Bids Details:");
				System.out.println("Bid ID " + b.getBid());
				System.out.println("Tender ID " + b.getTid());
				System.out.println("Vendor ID " + b.getVid());
				System.out.println("Bid Amount " + b.getBidAmount());
				System.out.println("=================================");

				count++;
			}
		}
	}

	public void getStatusOfABid() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the Bid Id");
		String bidId = sc.nextLine();

		BidderDao bdao = new BidderDaoImpl();

		String status = bdao.getStatusOfABid(bidId);

		System.out.println("Status for " + bidId + " is " + status);

	}

}
