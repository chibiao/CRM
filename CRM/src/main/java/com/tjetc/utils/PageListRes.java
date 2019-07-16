package com.tjetc.utils;

import java.util.List;

public class PageListRes {
	// 返回的状态 成功状态为0
	private int code;
	// 返回的信息
	private String msg;
	// 返回的数据总数量
	private long count;
	// 返回的数据
	private List<?> data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}
}
