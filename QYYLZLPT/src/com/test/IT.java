package com.test;

public class IT {
	private int itid;
	private String itname;

	public void setItname(String itname) {
		this.itname = itname;
	}

	public String getItname() {
		return itname;
	}

	public void setItid(int itid) {
		this.itid = itid;
	}

	public int getItid() {
		return itid;
	}

	@Override
	public String toString() {
		return "IT [itid=" + itid + ", itname=" + itname + "]";
	}

}