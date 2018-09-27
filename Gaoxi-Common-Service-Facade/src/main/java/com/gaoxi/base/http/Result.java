package com.gaoxi.base.http;

import java.io.Serializable;

public class Result implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1063278289490780877L;

	private String code;
	
	private String msg;
	
	private Object data;

	public String getCode() {
		return code;
	}
	

	public void setCode(String code) {
		this.code = code;
	}
	

	public String getMsg() {
		return msg;
	}
	

	public void setMsg(String msg) {
		this.msg = msg;
	}
	

	public Object getData() {
		return data;
	}
	

	public void setData(Object data) {
		this.data = data;
	}


	public Result(String code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	public static Result success(Object data){
		return new Result("200","sucess",data);
	}
	
}
