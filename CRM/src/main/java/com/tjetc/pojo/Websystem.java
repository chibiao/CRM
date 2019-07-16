package com.tjetc.pojo;

public class Websystem {
private Integer sysremid;
private String systemname;//系统名称
private String syslogoip;//系统图片路径
private String copyright;//系统版权
private String title;//系统标题
public Websystem() {
	super();
}
public Websystem(int sysremid, String systemname, String syslogoip, String copyright, String title) {
	super();
	this.sysremid = sysremid;
	this.systemname = systemname;
	this.syslogoip = syslogoip;
	this.copyright = copyright;
	this.title = title;
}
/**
 * @return the sysremid
 */
public final Integer getSysremid() {
	return sysremid;
}
/**
 * @param sysremid the sysremid to set
 */
public final void setSysremid(Integer sysremid) {
	this.sysremid = sysremid;
}
/**
 * @return the systemname
 */
public final String getSystemname() {
	return systemname;
}
/**
 * @param systemname the systemname to set
 */
public final void setSystemname(String systemname) {
	this.systemname = systemname;
}
/**
 * @return the syslogoip
 */
public final String getSyslogoip() {
	return syslogoip;
}
/**
 * @param syslogoip the syslogoip to set
 */
public final void setSyslogoip(String syslogoip) {
	this.syslogoip = syslogoip;
}
/**
 * @return the copyright
 */
public final String getCopyright() {
	return copyright;
}
/**
 * @param copyright the copyright to set
 */
public final void setCopyright(String copyright) {
	this.copyright = copyright;
}
/**
 * @return the title
 */
public final String getTitle() {
	return title;
}
/**
 * @param title the title to set
 */
public final void setTitle(String title) {
	this.title = title;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Websystem [sysremid=" + sysremid + ", systemname=" + systemname + ", syslogoip=" + syslogoip
			+ ", copyright=" + copyright + ", title=" + title + "]";
}

}
