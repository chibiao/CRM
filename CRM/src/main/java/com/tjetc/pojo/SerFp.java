package com.tjetc.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SerFp {
    private Integer id;//编号

    private String cname;//被分配人（客户经理）

    private String ftime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());//分配时间

    private String fname;//分配人（销售经理 ）

    public SerFp() {
		super();
	}

	public SerFp(Integer id, String cname, String ftime, String fname) {
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

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getFtime() {
        return ftime;
    }

    public void setFtime(String ftime) {
        this.ftime = ftime == null ? null : ftime.trim();
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

	@Override
	public String toString() {
		return "SerFp [id=" + id + ", cname=" + cname + ", ftime=" + ftime + ", fname=" + fname + "]";
	}
    
}