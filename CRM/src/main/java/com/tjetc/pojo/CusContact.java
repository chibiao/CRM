package com.tjetc.pojo;

/*
 * 客户交往记录
 */
public class CusContact {
	// 交往记录id
	private Integer conid;
	// 交往记录日期
	private String condate;
	// 交往记录地址
	private String conAddr;
	// 交往记录信息
	private String conIfno;
	// 交往记录备注
	private String conRemark;
	//客户id
	private Integer cid;
	private Customer customer;
	
	public Integer getConid() {
		return conid;
	}

	public void setConid(Integer conid) {
		this.conid = conid;
	}

	public String getCondate() {
		return condate;
	}

	public void setCondate(String condate) {
		this.condate = condate == null ? null : condate.trim();
	}

	public String getConAddr() {
		return conAddr;
	}

	public void setConAddr(String conAddr) {
		this.conAddr = conAddr == null ? null : conAddr.trim();
	}

	public String getConIfno() {
		return conIfno;
	}

	public void setConIfno(String conIfno) {
		this.conIfno = conIfno;
	}

	public String getConRemark() {
		return conRemark;
	}

	public void setConRemark(String conRemark) {
		this.conRemark = conRemark == null ? null : conRemark.trim();
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public CusContact() {
		super();
	}

	public CusContact(Integer conid, String condate, String conAddr,
			String conIfno, String conRemark/*, Integer cid*/) {
		super();
		this.conid = conid;
		this.condate = condate;
		this.conAddr = conAddr;
		this.conIfno = conIfno;
		this.conRemark = conRemark;
		/*this.cid = cid;*/
	}

	public CusContact(String condate, String conAddr, String conIfno,
			String conRemark) {
		super();
		this.condate = condate;
		this.conAddr = conAddr;
		this.conIfno = conIfno;
		this.conRemark = conRemark;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CusContact(Integer conid, String condate, String conAddr, String conIfno, String conRemark,
			Customer customer) {
		super();
		this.conid = conid;
		this.condate = condate;
		this.conAddr = conAddr;
		this.conIfno = conIfno;
		this.conRemark = conRemark;
		this.customer = customer;
	}

	public CusContact(String condate, String conAddr, String conIfno, String conRemark, Customer customer) {
		super();
		this.condate = condate;
		this.conAddr = conAddr;
		this.conIfno = conIfno;
		this.conRemark = conRemark;
		this.customer = customer;
	}

	public CusContact(String conAddr) {
		super();
		this.conAddr = conAddr;
	}

	

	public CusContact(String condate, String conAddr, String conIfno, String conRemark, Integer cid) {
		super();
		this.condate = condate;
		this.conAddr = conAddr;
		this.conIfno = conIfno;
		this.conRemark = conRemark;
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "CusContact [conid=" + conid + ", condate=" + condate + ", conAddr=" + conAddr + ", conIfno=" + conIfno
				+ ", conRemark=" + conRemark + "]";
	}


}