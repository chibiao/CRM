package com.tjetc.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SerCj {
    private Integer id;//编号（自动生成）

    private String types;//服务类型

    private String description;//概要

    private String custom;//客户

    private Integer state;//状态（新创建 0，已分配 1，已处理 2，已归档 3）满意度>=3已归档  满意度<3已分配

    private String cname;//创建人  （客户经理）

    private String ctime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());//创建时间

    private String req;//服务请求  富文本编辑
    

    public SerCj() {
		super();
	}

	public SerCj(Integer id, String types, String description, String custom, Integer state, String cname, String ctime,
			String req) {
		super();
		this.id = id;
		this.types = types;
		this.description = description;
		this.custom = custom;
		this.state = state;
		this.cname = cname;
		this.ctime = ctime;
		this.req = req;
	}

	public SerCj(String types, String description, String custom, Integer state, String cname, String ctime,
			String req) {
		super();
		this.types = types;
		this.description = description;
		this.custom = custom;
		this.state = state;
		this.cname = cname;
		this.ctime = ctime;
		this.req = req;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types == null ? null : types.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom == null ? null : custom.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime == null ? null : ctime.trim();
    }

    public String getReq() {
        return req;
    }

    public void setReq(String req) {
        this.req = req == null ? null : req.trim();
    }

	@Override
	public String toString() {
		return "SerCj [id=" + id + ", types=" + types + ", description=" + description + ", custom=" + custom
				+ ", state=" + state + ", cname=" + cname + ", ctime=" + ctime + ", req=" + req + "]";
	}
    
}