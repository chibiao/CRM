package com.tjetc.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class Goods implements Serializable {
	private int gid; //编号
	private String title;//名称
	private String type;//型号
	private String level;//等级
	private String unit;//单位
	private double price;//单价
	private int count;//库存
	private String content;//备注
	private String storehouse;//所在仓库
	private String birthday=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStorehouse() {
		return storehouse;
	}
	public void setStorehouse(String storehouse) {
		this.storehouse = storehouse;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", title=" + title + ", type=" + type + ", level=" + level + ", unit=" + unit
				+ ", price=" + price + ", count=" + count + ", content=" + content + ", storehouse=" + storehouse
				+ ", birthday=" + birthday + "]";
	}

}
