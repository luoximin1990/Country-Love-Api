package com.marykay.country.love.api.contract.request;

import javax.validation.constraints.NotNull;

public class GetUserLoginRequest {
    @NotNull(message = "login name cannot be empty")
    private String mobile ;
    @NotNull(message = "login password cannot be empty")
    private String password;

    public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
