package com.tjetc.pojo;

public class CusRank {
	private int rid;
	private String rname;
	public CusRank(int rid, String rname) {
		super();
		this.rid = rid;
		this.rname = rname;
	}
	public CusRank(String rname) {
		super();
		this.rname = rname;
	}
	public CusRank() {
		super();
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	@Override
	public String toString() {
		return "CusRank [rid=" + rid + ", rname=" + rname + "]";
	}
	
	
}
