package com.hyhg.web.common;

import com.hyhg.domain.base.Base;

public class RestResult<T> extends Base {

	private static final long serialVersionUID = 4308014910498100237L;
	
	/**
	 * 返回的结果对象
	 */
	private T model;
	
	/**
	 * 是否成功
	 */
	private boolean success = true;
	
	/**
	 * 错误码
	 */
	private int errorCode;
	
	/**
	 * 错误信息
	 */
	public String errorMsg;
	
	public RestResult(){}

	public RestResult(T model, boolean success, int errorCode, String errorMsg) {
		super();
		this.model = model;
		this.success = success;
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	

}
