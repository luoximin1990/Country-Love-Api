package com.marykay.country.love.api.contract.request;

import javax.validation.constraints.NotNull;

public class ChangePasswordRequest {

	private Integer id;

	@NotNull(message = "the password can't be empty")
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
