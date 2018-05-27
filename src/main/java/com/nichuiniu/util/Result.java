package com.nichuiniu.util;

/**
 * 结果基类,用来进行各种操作接口的数据传输基类
 * 
 */
public class Result {

	private boolean success;// 操作是否成功 True|False
	private String message;// 操作返回的消息

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success
	 *            the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean isFailed() {
		return !success;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 
	 */
	public Result() {
		super();
	}

	/**
	 * @param success
	 * @param message
	 */
	public Result(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Result [success=" + success + ", message=" + message + "]";
	}

}
