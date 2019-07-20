package com.tjetc.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SerFp {
    private String id;//编号

    private String cname;//被分配人（客户经理）

    private String ftime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());//分配时间

    private String fname;//分配人（销售经理 ）
    
    private SerCj sercj;
    
    

	public SerCj getSercj() {
		return sercj;
	}

	public void setSercj(SerCj sercj) {
		this.sercj = sercj;
	}

	public SerFp(SerCj sercj) {
		super();
		this.sercj = sercj;
	}

	public SerFp(String cname, String ftime, String fname, SerCj sercj) {
		super();
		this.cname = cname;
		this.ftime = ftime;
		this.fname = fname;
		this.sercj = sercj;
	}

	public SerFp(String id, String cname, String ftime, String fname, SerCj sercj) {
		super();
		this.id = id;
		this.cname = cname;
		this.ftime = ftime;
		this.fname = fname;
		this.sercj = sercj;
	}

	public SerFp(String id, String cname, String ftime, String fname) {
		super();
		this.id = id;
		this.cname = cname;
		this.ftime = ftime;
		this.fname = fname;
	}

	public SerFp(String cname, String ftime, String fname) {
		super();
		this.cname = cname;
		this.ftime = ftime;
		this.fname = fname;
	}

	public SerFp() {
		super();
	}

	public String getId() {
		return id;
	}

	public String getCname() {
		return cname;
	}

	public String getFtime() {
		return ftime;
	}

	public String getFname() {
		return fname;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public void setFtime(String ftime) {
		this.ftime = ftime;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	@Override
	public String toString() {
		return "SerFp [id=" + id + ", cname=" + cname + ", ftime=" + ftime + ", fname=" + fname + ", sercj=" + sercj
				+ "]";
	}

   
    
}