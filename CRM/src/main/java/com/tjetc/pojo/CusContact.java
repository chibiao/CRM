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
	private String conaddr;
	// 交往记录信息
	private Integer conifno;
	// 交往记录备注
	private String conremark;
	// 客户id
	private Integer cid;

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

	public String getConaddr() {
		return conaddr;
	}

	public void setConaddr(String conaddr) {
		this.conaddr = conaddr == null ? null : conaddr.trim();
	}

	public Integer getConifno() {
		return conifno;
	}

	public void setConifno(Integer conifno) {
		this.conifno = conifno;
	}

	public String getConremark() {
		return conremark;
	}

	public void setConremark(String conremark) {
		this.conremark = conremark == null ? null : conremark.trim();
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

	public CusContact(Integer conid, String condate, String conaddr,
			Integer conifno, String conremark, Integer cid) {
		super();
		this.conid = conid;
		this.condate = condate;
		this.conaddr = conaddr;
		this.conifno = conifno;
		this.conremark = conremark;
		this.cid = cid;
	}

	public CusContact(String condate, String conaddr, Integer conifno,
			String conremark) {
		super();
		this.condate = condate;
		this.conaddr = conaddr;
		this.conifno = conifno;
		this.conremark = conremark;
	}

	@Override
	public String toString() {
		return "CusContact [conid=" + conid + ", condate=" + condate
				+ ", conaddr=" + conaddr + ", conifno=" + conifno
				+ ", conremark=" + conremark + ", cid=" + cid + "]";
	}

}