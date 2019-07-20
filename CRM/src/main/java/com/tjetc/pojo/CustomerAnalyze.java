package com.tjetc.pojo;

public class CustomerAnalyze {
private String name;
private int num;
private int cusCredi;
private int cusSati;
public CustomerAnalyze() {
	super();
	// TODO Auto-generated constructor stub
}
public CustomerAnalyze(String name, int num) {
	super();
	this.name = name;
	this.num = num;
}

public CustomerAnalyze(String name, int num, int cusCredi) {
	super();
	this.name = name;
	this.num = num;
	this.cusCredi = cusCredi;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}

public int getCusCredi() {
	return cusCredi;
}
public void setCusCredi(int cusCredi) {
	this.cusCredi = cusCredi;
}

public int getCusSati() {
	return cusSati;
}
public void setCusSati(int cusSati) {
	this.cusSati = cusSati;
}
@Override
public String toString() {
	return "CustomerAnalyze [name=" + name + ", num=" + num + ", cusCredi=" + cusCredi + ", cusSati=" + cusSati + "]";
}



}
