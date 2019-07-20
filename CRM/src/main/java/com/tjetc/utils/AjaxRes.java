package com.tjetc.utils;

/**
 * 用于返回ajax修改数据后的结果
 * 
 * @author 迟彪
 *
 */
public class AjaxRes {
	// 返回的消息
	private String msg;
	// 返回请求是否成功
	private Boolean success;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

}
