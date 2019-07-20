package com.tjetc.pojo;

import java.util.Date;

public class CusLost {
    private Integer lostid;

    private String lastordertime;

    private String lasttime;

    private String lastreason;

    private String lastdelay;

    private Integer laststatus;

    private Integer cid;
    private String cusname;
    private Integer cmid;
    private Customer customer;

    
    public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getLostid() {
        return lostid;
    }

    public String getCusname() {
		return cusname;
	}

	public void setCusname(String cusname) {
		this.cusname = cusname;
	}

	public void setLostid(Integer lostid) {
        this.lostid = lostid;
    }

    public String getLastordertime() {
        return lastordertime;
    }

    public void setLastordertime(String lastordertime) {
        this.lastordertime = lastordertime == null ? null : lastordertime.trim();
    }

    

    public String getLasttime() {
		return lasttime;
	}

	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}

	public String getLastreason() {
        return lastreason;
    }

    public void setLastreason(String lastreason) {
        this.lastreason = lastreason == null ? null : lastreason.trim();
    }

    public String getLastdelay() {
        return lastdelay;
    }

    public void setLastdelay(String lastdelay) {
        this.lastdelay = lastdelay == null ? null : lastdelay.trim();
    }

    public Integer getLaststatus() {
        return laststatus;
    }

    public void setLaststatus(Integer laststatus) {
        this.laststatus = laststatus;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getCmid() {
        return cmid;
    }

    public void setCmid(Integer cmid) {
        this.cmid = cmid;
    }
}