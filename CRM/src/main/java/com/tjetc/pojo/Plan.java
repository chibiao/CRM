package com.tjetc.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date plantime;
	// 计划反馈
	private String planback;
	//发展计划的状态
	private Boolean state;

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

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

	@Override
	public String toString() {
		return "Plan [id=" + id + ", cusid=" + cusid + ", plan=" + plan
				+ ", plantime=" + plantime + ", planback=" + planback
				+ ", state=" + state + "]";
	}
	
}