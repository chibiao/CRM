package com.tjetc.pojo;

import java.util.HashSet;
import java.util.Set;

/*
  *  客户管理:客户实体类
 */
public class Customer {
	//客户id
    private Integer id;
  //客户编号
    private String cusid;
  //客户名称
    private String cusname;
  //客户所属地区
    private String cusregion;
  //客户具体地址
    private String cusaddr;
  //创建客户时间
    private String cuscreatetime;
  //客户传真
    private String cusfax;
  //客户邮编
    private String cuszip;
  //客户网址
    private String cuswebsite;
  //客户法人名称
    private String chieftain;
  //经理id
    private Integer cusmanagerid;
  //客户银行
    private String bank;
  //客户银行卡号
    private String bankacount;
  //客户状态
    private Integer cusstatus;
  //客户等级id
    private Integer rid;
  //客户logo
    private String logo;
  //客户满意度
    private Integer cussati;
  //客户满意度
    private Integer cuscredi;
    //联系人集合
    private Set<CusLinkman> cuslinkman=new HashSet<CusLinkman>();
//交往记录集合
    private Set<CusContact> cuscontacts=new HashSet<CusContact>();
public Customer(Integer id, String cusid, String cusname, String cusregion, String cusaddr, String cuscreatetime,
		String cusfax, String cuszip, String cuswebsite, String chieftain, Integer cusmanagerid, String bank,
		String bankacount, Integer cusstatus, Integer rid, String logo, Integer cussati, Integer cuscredi,
		Set<CusLinkman> cuslinkman, Set<CusContact> cuscontacts) {
	super();
	this.id = id;
	this.cusid = cusid;
	this.cusname = cusname;
	this.cusregion = cusregion;
	this.cusaddr = cusaddr;
	this.cuscreatetime = cuscreatetime;
	this.cusfax = cusfax;
	this.cuszip = cuszip;
	this.cuswebsite = cuswebsite;
	this.chieftain = chieftain;
	this.cusmanagerid = cusmanagerid;
	this.bank = bank;
	this.bankacount = bankacount;
	this.cusstatus = cusstatus;
	this.rid = rid;
	this.logo = logo;
	this.cussati = cussati;
	this.cuscredi = cuscredi;
	this.cuslinkman = cuslinkman;
	this.cuscontacts = cuscontacts;
}
public Customer(String cusid, String cusname, String cusregion, String cusaddr, String cuscreatetime, String cusfax,
		String cuszip, String cuswebsite, String chieftain, Integer cusmanagerid, String bank, String bankacount,
		Integer cusstatus, Integer rid, String logo, Integer cussati, Integer cuscredi, Set<CusLinkman> cuslinkman,
		Set<CusContact> cuscontacts) {
	super();
	this.cusid = cusid;
	this.cusname = cusname;
	this.cusregion = cusregion;
	this.cusaddr = cusaddr;
	this.cuscreatetime = cuscreatetime;
	this.cusfax = cusfax;
	this.cuszip = cuszip;
	this.cuswebsite = cuswebsite;
	this.chieftain = chieftain;
	this.cusmanagerid = cusmanagerid;
	this.bank = bank;
	this.bankacount = bankacount;
	this.cusstatus = cusstatus;
	this.rid = rid;
	this.logo = logo;
	this.cussati = cussati;
	this.cuscredi = cuscredi;
	this.cuslinkman = cuslinkman;
	this.cuscontacts = cuscontacts;
}
public Customer() {
	super();
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getCusid() {
	return cusid;
}
public void setCusid(String cusid) {
	this.cusid = cusid;
}
public String getCusname() {
	return cusname;
}
public void setCusname(String cusname) {
	this.cusname = cusname;
}
public String getCusregion() {
	return cusregion;
}
public void setCusregion(String cusregion) {
	this.cusregion = cusregion;
}
public String getCusaddr() {
	return cusaddr;
}
public void setCusaddr(String cusaddr) {
	this.cusaddr = cusaddr;
}
public String getCuscreatetime() {
	return cuscreatetime;
}
public void setCuscreatetime(String cuscreatetime) {
	this.cuscreatetime = cuscreatetime;
}
public String getCusfax() {
	return cusfax;
}
public void setCusfax(String cusfax) {
	this.cusfax = cusfax;
}
public String getCuszip() {
	return cuszip;
}
public void setCuszip(String cuszip) {
	this.cuszip = cuszip;
}
public String getCuswebsite() {
	return cuswebsite;
}
public void setCuswebsite(String cuswebsite) {
	this.cuswebsite = cuswebsite;
}
public String getChieftain() {
	return chieftain;
}
public void setChieftain(String chieftain) {
	this.chieftain = chieftain;
}
public Integer getCusmanagerid() {
	return cusmanagerid;
}
public void setCusmanagerid(Integer cusmanagerid) {
	this.cusmanagerid = cusmanagerid;
}
public String getBank() {
	return bank;
}
public void setBank(String bank) {
	this.bank = bank;
}
public String getBankacount() {
	return bankacount;
}
public void setBankacount(String bankacount) {
	this.bankacount = bankacount;
}
public Integer getCusstatus() {
	return cusstatus;
}
public void setCusstatus(Integer cusstatus) {
	this.cusstatus = cusstatus;
}
public Integer getRid() {
	return rid;
}
public void setRid(Integer rid) {
	this.rid = rid;
}
public String getLogo() {
	return logo;
}
public void setLogo(String logo) {
	this.logo = logo;
}
public Integer getCussati() {
	return cussati;
}
public void setCussati(Integer cussati) {
	this.cussati = cussati;
}
public Integer getCuscredi() {
	return cuscredi;
}
public void setCuscredi(Integer cuscredi) {
	this.cuscredi = cuscredi;
}
public Set<CusLinkman> getCuslinkman() {
	return cuslinkman;
}
public void setCuslinkman(Set<CusLinkman> cuslinkman) {
	this.cuslinkman = cuslinkman;
}
public Set<CusContact> getCuscontacts() {
	return cuscontacts;
}
public void setCuscontacts(Set<CusContact> cuscontacts) {
	this.cuscontacts = cuscontacts;
}
@Override
public String toString() {
	return "Customer [id=" + id + ", cusid=" + cusid + ", cusname=" + cusname + ", cusregion=" + cusregion
			+ ", cusaddr=" + cusaddr + ", cuscreatetime=" + cuscreatetime + ", cusfax=" + cusfax + ", cuszip=" + cuszip
			+ ", cuswebsite=" + cuswebsite + ", chieftain=" + chieftain + ", cusmanagerid=" + cusmanagerid + ", bank="
			+ bank + ", bankacount=" + bankacount + ", cusstatus=" + cusstatus + ", rid=" + rid + ", logo=" + logo
			+ ", cussati=" + cussati + ", cuscredi=" + cuscredi + ", cuslinkman=" + cuslinkman + ", cuscontacts="
			+ cuscontacts + "]";
}
    
   

	
    
}