package com.tjetc.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SerCl {
    private Integer id;//编号

    private String clname;//处理人（客户经理）

    private String cltime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());//处理时间

    private String handle;//服务处理  富文本编辑

    public SerCl() {
		super();
	}

	public SerCl(Integer id, String clname, String cltime, String handle) {
		super();
		this.id = id;
		this.clname = clname;
		this.cltime = cltime;
		this.handle = handle;
	}

	public SerCl(String clname, String cltime, String handle) {
		super();
		this.clname = clname;
		this.cltime = cltime;
		this.handle = handle;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClname() {
        return clname;
    }

    public void setClname(String clname) {
        this.clname = clname == null ? null : clname.trim();
    }

    public String getCltime() {
        return cltime;
    }

    public void setCltime(String cltime) {
        this.cltime = cltime == null ? null : cltime.trim();
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle == null ? null : handle.trim();
    }

	@Override
	public String toString() {
		return "SerCl [id=" + id + ", clname=" + clname + ", cltime=" + cltime + ", handle=" + handle + "]";
	}
    
}