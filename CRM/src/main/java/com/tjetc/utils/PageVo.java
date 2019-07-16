package com.tjetc.utils;

/**
 * 用于接收前端分页发送的页面和查询条数
 * 
 * @author 迟彪
 *
 */
public class PageVo {
	// 页码
	private int page;
	// 要查询的记录条数
	private int limit;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
