package com.tjetc.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/*
 * 营销机会
 */
public class Chance {
	// 编号
	private Integer id;
	// 机会来源
	private String chancefrom;
	// 客户名称
	private String cusname;
	// 成功几率
	private Integer successpro;
	// 概要
	private String outline;
	// 联系人
	private String contacts;
	// 联系人电话
	private String phone;
	// 描述
	private String description;
	// 创建人
	private String founder;
	// 创建时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date creattime;
	// 指派给谁名称
	private String assigned;
	// 指派时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date assignedtime;
	// 指派的人的id
	private Integer assignedid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChancefrom() {
		return chancefrom;
	}

	public void setChancefrom(String chancefrom) {
		this.chancefrom = chancefrom == null ? null : chancefrom.trim();
	}

	public String getCusname() {
		return cusname;
	}

	public void setCusname(String cusname) {
		this.cusname = cusname == null ? null : cusname.trim();
	}

	public Integer getSuccesspro() {
		return successpro;
	}

	public void setSuccesspro(Integer successpro) {
		this.successpro = successpro;
	}

	public String getOutline() {
		return outline;
	}

	public void setOutline(String outline) {
		this.outline = outline == null ? null : outline.trim();
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts == null ? null : contacts.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getFounder() {
		return founder;
	}

	public void setFounder(String founder) {
		this.founder = founder == null ? null : founder.trim();
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public String getAssigned() {
		return assigned;
	}

	public void setAssigned(String assigned) {
		this.assigned = assigned == null ? null : assigned.trim();
	}

	public Date getAssignedtime() {
		return assignedtime;
	}

	public void setAssignedtime(Date assignedtime) {
		this.assignedtime = assignedtime;
	}

	public Integer getAssignedid() {
		return assignedid;
	}

	public void setAssignedid(Integer assignedid) {
		this.assignedid = assignedid;
	}

	@Override
	public String toString() {
		return "Chance [id=" + id + ", chancefrom=" + chancefrom + ", cusname="
				+ cusname + ", successpro=" + successpro + ", outline="
				+ outline + ", contacts=" + contacts + ", phone=" + phone
				+ ", description=" + description + ", founder=" + founder
				+ ", creattime=" + creattime + ", assigned=" + assigned
				+ ", assignedtime=" + assignedtime + ", assignedid="
				+ assignedid + "]";
	}
}