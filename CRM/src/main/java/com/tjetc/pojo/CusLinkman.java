package com.tjetc.pojo;
/*
 * 联系人
 */
public class CusLinkman {
	//联系人id
    private Integer lkmid;
  //联系人姓名
    private String lkmname;
  //联系人电话
    private String lkmphone;
  //联系人性别
    private String lkmsex;
  //客户id
    private Integer cid;
    //客户对象
    private Customer customer;


    
    public CusLinkman(String lkmname, String lkmphone, String lkmsex) {
		super();
		this.lkmname = lkmname;
		this.lkmphone = lkmphone;
		this.lkmsex = lkmsex;
	}

    
	public CusLinkman(String lkmname, String lkmphone, String lkmsex, Integer cid) {
		super();
		this.lkmname = lkmname;
		this.lkmphone = lkmphone;
		this.lkmsex = lkmsex;
		this.cid = cid;
	}


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getLkmid() {
        return lkmid;
    }

    public void setLkmid(Integer lkmid) {
        this.lkmid = lkmid;
    }

    public String getLkmname() {
        return lkmname;
    }

    public void setLkmname(String lkmname) {
        this.lkmname = lkmname == null ? null : lkmname.trim();
    }

    public String getLkmphone() {
        return lkmphone;
    }

    public void setLkmphone(String lkmphone) {
        this.lkmphone = lkmphone == null ? null : lkmphone.trim();
    }

    public String getLkmsex() {
        return lkmsex;
    }

    public void setLkmsex(String lkmsex) {
        this.lkmsex = lkmsex == null ? null : lkmsex.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

	public CusLinkman() {
		super();
	}

	public CusLinkman(Integer lkmid, String lkmname, String lkmphone, String lkmsex, Integer cid, Customer customer) {
		super();
		this.lkmid = lkmid;
		this.lkmname = lkmname;
		this.lkmphone = lkmphone;
		this.lkmsex = lkmsex;
		this.cid = cid;
		this.customer = customer;
	}

	public CusLinkman(String lkmname, String lkmphone, String lkmsex, Integer cid, Customer customer) {
		super();
		this.lkmname = lkmname;
		this.lkmphone = lkmphone;
		this.lkmsex = lkmsex;
		this.cid = cid;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CusLinkman [lkmid=" + lkmid + ", lkmname=" + lkmname + ", lkmphone=" + lkmphone + ", lkmsex=" + lkmsex
				+ "]";
	}
    
    
}