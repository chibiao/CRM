package com.tjetc.pojo;

import java.util.Date;

/*
 * 发展计划
 */
public class Plan {
	// 计划编号
	private Integer id;
	// 客户编号
	private Integer cusid;
	// 计划项
	private String plan;
	// 计划时间
	private Date plantime;
	// 计划反馈
	private String planback;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCusid() {
		return cusid;
	}

	public void setCusid(Integer cusid) {
		this.cusid = cusid;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan == null ? null : plan.trim();
	}

	public Date getPlantime() {
		return plantime;
	}

	public void setPlantime(Date plantime) {
		this.plantime = plantime;
	}

	public String getPlanback() {
		return planback;
	}

	public void setPlanback(String planback) {
		this.planback = planback == null ? null : planback.trim();
	}
}