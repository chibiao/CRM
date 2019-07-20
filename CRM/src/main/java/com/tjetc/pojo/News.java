package com.tjetc.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class News implements Serializable {
	private int nid;//新闻编号
	private String title;//新闻标题
	private String writer;//新闻作者
	private String remarks;//新闻备注
	private String content;//新闻内容
	private String birthday=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	private String classify;//新闻分类
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	@Override
	public String toString() {
		return "News [nid=" + nid + ", title=" + title + ", writer=" + writer + ", remarks=" + remarks + ", content="
				+ content + ", birthday=" + birthday + ", classify=" + classify + "]";
	}


}
