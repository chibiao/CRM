package com.tjetc.pojo;

import java.util.ArrayList;
import java.util.List;

public class Power {
	private int id; // 一级权限编号
	private String name; // 一级权限名称
	List<SecondPower> secondPowers = new ArrayList<>(); // 一级权限所拥有的二级权限

	public Power(int id, String name, List<SecondPower> secondPowers) {
		super();
		this.id = id;
		this.name = name;
		this.secondPowers = secondPowers;
	}

	public Power(String name, List<SecondPower> secondPowers) {
		super();
		this.name = name;
		this.secondPowers = secondPowers;
	}

	public Power(String name) {
		super();
		this.name = name;
	}

	public Power() {
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

	public List<SecondPower> getSecondPowers() {
		return secondPowers;
	}

	public void setSecondPowers(List<SecondPower> secondPowers) {
		this.secondPowers = secondPowers;
	}

	@Override
	public String toString() {
		return "Power [id=" + id + ", name=" + name + "]";
	}

}
