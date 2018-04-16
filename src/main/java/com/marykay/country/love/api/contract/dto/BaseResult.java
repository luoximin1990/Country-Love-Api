package com.marykay.country.love.api.contract.dto;

import java.io.Serializable;

public class BaseResult implements Serializable {

	public Integer code;

    public Object content;

    public String msg;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
