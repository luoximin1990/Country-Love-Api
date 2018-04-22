package com.marykay.country.love.api.contract.request;

import org.hibernate.validator.constraints.NotBlank;

public class PayNotifyRequest {

	// 手机号
	@NotBlank
	private String mobile;

	// 订单编号
	@NotBlank
	private String orderuid;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOrderuid() {
		return orderuid;
	}

	public void setOrderuid(String orderuid) {
		this.orderuid = orderuid;
	}

}
