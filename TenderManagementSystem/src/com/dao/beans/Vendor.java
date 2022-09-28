package com.dao.beans;

import java.util.List;

public class Vendor {

	private int vid;
	private String vusername;
	private String vpassword;
	private String vemail;
	private String vname;
	private String vaddress;
	private List<Integer> vtid;

	public Vendor() {
		super();
	}

	public Vendor(int vid, String vusername, String vpassword, String vemail, String vname, String vaddress,
			List<Integer> vtid) {
		super();
		this.vid = vid;
		this.vusername = vusername;
		this.vpassword = vpassword;
		this.vemail = vemail;
		this.vname = vname;
		this.vaddress = vaddress;
		this.vtid = vtid;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getVusername() {
		return vusername;
	}

	public void setVusername(String vusername) {
		this.vusername = vusername;
	}

	public String getVpassword() {
		return vpassword;
	}

	public void setVpassword(String vpassword) {
		this.vpassword = vpassword;
	}

	public String getVemail() {
		return vemail;
	}

	public void setVemail(String vemail) {
		this.vemail = vemail;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getVaddress() {
		return vaddress;
	}

	public void setVaddress(String vaddress) {
		this.vaddress = vaddress;
	}

	public List<Integer> getVtid() {
		return vtid;
	}

	public void setVtid(List<Integer> vtid) {
		this.vtid = vtid;
	}

	@Override
	public String toString() {
		return "Vendor [vid=" + vid + ", vusername=" + vusername + ", vpassword=" + vpassword + ", vemail=" + vemail
				+ ", vname=" + vname + ", vaddress=" + vaddress + ", vtid=" + vtid + "]";
	}

}
