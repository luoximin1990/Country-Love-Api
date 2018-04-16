package com.marykay.country.love.api.contract.request;

import javax.validation.constraints.NotNull;

public class ChangeMobileRequest {

	private Integer id;

	@NotNull(message = "the mobile can't be empty")
	private String mobile;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
