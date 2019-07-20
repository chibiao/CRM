package com.tjetc.pojo;

import java.util.ArrayList;
import java.util.List;

public class Power {
	private int id; // 一级权限编号
	private String name; // 一级权限名称
	private String presource;//资源
	private Integer parent_id;//二级权限所属id
	

	public Power(int id, String name, String presource, Integer parent_id) {
		super();
		this.id = id;
		this.name = name;
		this.presource = presource;
		this.parent_id = parent_id;
	}



	public Power(String name, String presource, Integer parent_id) {
		super();
		this.name = name;
		this.presource = presource;
		this.parent_id = parent_id;
		
	}

	public Power(String name, Integer parent_id) {
		super();
		this.name = name;
		this.parent_id = parent_id;
	}

	public Power(String name) {
		super();
		this.name = name;
	}

	public String getPresource() {
		return presource;
	}



	public void setPresource(String presource) {
		this.presource = presource;
	}



	public Integer getParent_id() {
		return parent_id;
	}



	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
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



	@Override
	public String toString() {
		return "Power [id=" + id + ", name=" + name + ", presource=" + presource + ", parent_id=" + parent_id + "]";
	}

	

}
