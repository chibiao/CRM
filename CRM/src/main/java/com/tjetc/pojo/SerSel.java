package com.tjetc.pojo;

public class SerSel {
	private String tname;
	private int tsum;
	private String ctime;
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getTsum() {
		return tsum;
	}
	public void setTsum(int tsum) {
		this.tsum = tsum;
	}
	public SerSel(String tname, int tsum) {
		super();
		this.tname = tname;
		this.tsum = tsum;
	}
	public SerSel() {
		super();
	}
	
	public SerSel(String tname, int tsum, String ctime) {
		super();
		this.tname = tname;
		this.tsum = tsum;
		this.ctime = ctime;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	@Override
	public String toString() {
		return "SerSel [tname=" + tname + ", tsum=" + tsum + ", ctime=" + ctime + "]";
	}
	
}
