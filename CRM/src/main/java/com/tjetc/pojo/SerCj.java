package com.tjetc.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SerCj {
    private String id;//编号（自动生成）uid

    private Integer types;//服务类型

    private String description;//概要

    private String custom;//客户

    private Integer state;//状态（新创建 0，已分配 1，已处理 2，已归档 3）满意度>=3已归档  满意度<3已分配

    private String cname;//创建人  （客户经理）

    private String ctime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());//创建时间

    private String req;//服务请求  富文本编辑
    
    private SerCl sercl;
    
    private SerFp serfp;

    private SerResult serresult;
    
    
	public SerCj(SerResult serresult) {
		super();
		this.serresult = serresult;
	}


	public SerCj(String id, Integer types, String description, String custom, Integer state, String cname, String ctime,
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


	public SerCj(String id, Integer types, String description, String custom, Integer state, String cname, String ctime,
			String req, SerCl sercl, SerFp serfp, SerResult serresult) {
		super();
		this.id = id;
		this.types = types;
		this.description = description;
		this.custom = custom;
		this.state = state;
		this.cname = cname;
		this.ctime = ctime;
		this.req = req;
		this.sercl = sercl;
		this.serfp = serfp;
		this.serresult = serresult;
	}


	public SerResult getSerresult() {
		return serresult;
	}


	public void setSerresult(SerResult serresult) {
		this.serresult = serresult;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Integer getTypes() {
		return types;
	}


	public void setTypes(Integer types) {
		this.types = types;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCustom() {
		return custom;
	}


	public void setCustom(String custom) {
		this.custom = custom;
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
		this.cname = cname;
	}


	public String getCtime() {
		return ctime;
	}


	public void setCtime(String ctime) {
		this.ctime = ctime;
	}


	public String getReq() {
		return req;
	}


	public void setReq(String req) {
		this.req = req;
	}


	public SerCl getSercl() {
		return sercl;
	}


	public void setSercl(SerCl sercl) {
		this.sercl = sercl;
	}


	public SerFp getSerfp() {
		return serfp;
	}


	public void setSerfp(SerFp serfp) {
		this.serfp = serfp;
	}


	public SerCj() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SerCj(String id, Integer types, String description, String custom, Integer state, String cname, String ctime,
			String req, SerCl sercl, SerFp serfp) {
		super();
		this.id = id;
		this.types = types;
		this.description = description;
		this.custom = custom;
		this.state = state;
		this.cname = cname;
		this.ctime = ctime;
		this.req = req;
		this.sercl = sercl;
		this.serfp = serfp;
	}

	public SerCj(Integer types, String description, String custom, Integer state, String cname, String ctime,
			String req, SerCl sercl, SerFp serfp) {
		super();
		this.types = types;
		this.description = description;
		this.custom = custom;
		this.state = state;
		this.cname = cname;
		this.ctime = ctime;
		this.req = req;
		this.sercl = sercl;
		this.serfp = serfp;
	}


	@Override
	public String toString() {
		return "SerCj [id=" + id + ", types=" + types + ", description=" + description + ", custom=" + custom
				+ ", state=" + state + ", cname=" + cname + ", ctime=" + ctime + ", req=" + req + ", sercl=" + sercl
				+ ", serfp=" + serfp + ", serresult=" + serresult + "]";
	}
    
    

  }