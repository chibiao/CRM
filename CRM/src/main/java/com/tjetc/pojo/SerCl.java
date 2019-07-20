package com.tjetc.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SerCl {
    private String id;//编号uid

    private String clname;//处理人（客户经理）

    private String cltime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());//处理时间

    private String handle;//服务处理  富文本编辑
    
    private SerCj sercj;

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClname() {
		return clname;
	}

	public void setClname(String clname) {
		this.clname = clname;
	}

	public String getCltime() {
		return cltime;
	}

	public void setCltime(String cltime) {
		this.cltime = cltime;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public SerCj getSercj() {
		return sercj;
	}

	public void setSercj(SerCj sercj) {
		this.sercj = sercj;
	}

	public SerCl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SerCl(String id, String clname, String cltime, String handle) {
		super();
		this.id = id;
		this.clname = clname;
		this.cltime = cltime;
		this.handle = handle;
	}

	public SerCl(String id, String clname, String cltime, String handle, SerCj sercj) {
		super();
		this.id = id;
		this.clname = clname;
		this.cltime = cltime;
		this.handle = handle;
		this.sercj = sercj;
	}

	public SerCl(String clname, String cltime, String handle) {
		super();
		this.clname = clname;
		this.cltime = cltime;
		this.handle = handle;
	}
    
	

    
}