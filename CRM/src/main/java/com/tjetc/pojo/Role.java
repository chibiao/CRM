package com.tjetc.pojo;

import java.util.ArrayList;
import java.util.List;

public class Role {
	private int id; // 角色编号
	private String name; // 角色名称
	private String des;//角色描述
	private List<Power> powers = new ArrayList<>(); // 角色所拥有的一级权限

	public Role(int id, String name, String des, List<Power> powers) {
		super();
		this.id = id;
		this.name = name;
		this.des = des;
		this.powers = powers;
	}

	

	public Role(String name, String des, List<Power> powers) {
		super();
		this.name = name;
		this.des = des;
		this.powers = powers;
	}

	public Role(String name, String des) {
		super();
		this.name = name;
		this.des = des;
	}
	

	public Role(String name) {
		super();
		this.name = name;
	}



	public Role() {
		super();
	}

	public String getDes() {
		return des;
	}



	public void setDes(String des) {
		this.des = des;
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

	public List<Power> getPowers() {
		return powers;
	}

	public void setPowers(List<Power> powers) {
		this.powers = powers;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", des=" + des + ", powers=" + powers + "]";
	}

}
