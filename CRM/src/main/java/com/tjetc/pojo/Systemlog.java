package com.tjetc.pojo;

import java.util.Date;

public class Systemlog {
    private Long id;

    private Date optime;

    private String ip;

    private String fnc;

    private String params;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOptime() {
        return optime;
    }

    public void setOptime(Date optime) {
        this.optime = optime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getFnc() {
        return fnc;
    }

    public void setFnc(String fnc) {
        this.fnc = fnc == null ? null : fnc.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }
}