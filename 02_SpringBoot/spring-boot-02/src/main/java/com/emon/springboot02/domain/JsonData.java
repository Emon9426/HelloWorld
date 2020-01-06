package com.emon.springboot02.domain;

import java.io.Serializable;

public class JsonData implements Serializable{

	private static final long serialVersionUID = 1L;
	//状态码
	// 0  - succ
	// -1 - fail
	private int code;
	//数据
	private Object data;
	private String message;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public JsonData(int code, Object data, String message) {
		super();
		this.code = code;
		this.data = data;
		this.message = message;
	}
	
}
