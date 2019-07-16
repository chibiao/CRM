package com.tjetc.pojo;

public class SecondPower {
	private int id; // 二级权限编号
	private String name; // 二级权限名称

	public SecondPower(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public SecondPower(String name) {
		super();
		this.name = name;
	}

	public SecondPower() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SecondPower [id=" + id + ", name=" + name + "]";
	}

}
