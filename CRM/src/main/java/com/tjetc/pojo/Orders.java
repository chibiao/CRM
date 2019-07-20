package com.tjetc.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Orders {
    private String orderid;

    private String orderaddr;

    private Integer orderstatus;

    private Double ordertotal;

    private Integer cid;
    
    private String time=new SimpleDateFormat("yyyy-MM-dd").format(new Date());

	public Orders(String orderid, String orderaddr, Integer orderstatus, Double ordertotal, Integer cid, String time) {
		super();
		this.orderid = orderid;
		this.orderaddr = orderaddr;
		this.orderstatus = orderstatus;
		this.ordertotal = ordertotal;
		this.cid = cid;
		this.time = time;
	}

	public Orders() {
		super();
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getOrderaddr() {
		return orderaddr;
	}

	public void setOrderaddr(String orderaddr) {
		this.orderaddr = orderaddr;
	}

	public Integer getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(Integer orderstatus) {
		this.orderstatus = orderstatus;
	}

	public Double getOrdertotal() {
		return ordertotal;
	}

	public void setOrdertotal(Double ordertotal) {
		this.ordertotal = ordertotal;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Orders [orderid=" + orderid + ", orderaddr=" + orderaddr + ", orderstatus=" + orderstatus
				+ ", ordertotal=" + ordertotal + ", cid=" + cid + ", time=" + time + "]";
	}

   
}