package com.tjetc.pojo;

public class LostReason {
  private int id;
  private String name;
  private int count;
  
public LostReason(int id, String name, int count) {
	super();
	this.id = id;
	this.name = name;
	this.count = count;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
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
public LostReason(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public LostReason() {
	super();
}
@Override
public String toString() {
	return "LostReason [id=" + id + ", name=" + name + "]";
}
  
}
