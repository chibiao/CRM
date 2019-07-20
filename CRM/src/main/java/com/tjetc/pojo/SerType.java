package com.tjetc.pojo;

public class SerType {
    private String id;
    private String tname;
	public SerType() {
		super();
	}
	public SerType(String id, String tname) {
		super();
		this.id = id;
		this.tname = tname;
	}
	public SerType(String tname) {
		super();
		this.tname = tname;
	}
	public String getId() {
		return id;
	}
	public String getTname() {
		return tname;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	@Override
	public String toString() {
		return "SerType [id=" + id + ", tname=" + tname + "]";
	}
	
}
