package com.nichuiniu.util;

import com.alibaba.fastjson.JSONObject;

/**
 * 处理结果基类
 * 
 * @author dmw
 *
 */
public class ZzResult extends Result {

	private Object data;// 操作返回的数据
	private String status;// 处理结果码
	private String solution;// 异常解决方案


	/**
	 *
	 */
	public ZzResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ZzResult(boolean success, String message) {
		super(success, message);
	}

	/**
	 * @param success
	 * @param data
	 * @param message
	 */
	public ZzResult(boolean success, Object data, String message) {
		super(success, message);
		this.data = data;
	}

	/**
	 * @param success
	 * @param message
	 * @param code
	 * @param solution
	 */
	public ZzResult(boolean success, String message, String code, String solution) {
		super(success, message);
		this.status = code;
		this.solution = solution;
	}

	public ZzResult(boolean success, Object data, String message, String status, String solution) {
		super(success, message);
		this.data = data;
		this.status = status;
		this.solution = solution;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the solution
	 */
	public String getSolution() {
		return solution;
	}

	/**
	 * @param solution
	 *            the solution to set
	 */
	public void setSolution(String solution) {
		this.solution = solution;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}
