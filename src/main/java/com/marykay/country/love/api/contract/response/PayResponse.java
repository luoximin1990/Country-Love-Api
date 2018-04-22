package com.marykay.country.love.api.contract.response;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

public class PayResponse {

	// 绿点支付生成的订单号
	@NotBlank
	private String greenpay_id;

	// 您的自定义订单号
	@NotBlank
	private String ordernum;

	// 订单定价
	@NotNull
	private float amount;

	// 实际支付金额
	@NotBlank
	private float realamount;

	// 您的自定义用户id编号
	@NotBlank
	private String orderuid;

	// 秘钥
	@NotBlank
	private String key;

	public String getGreenpay_id() {
		return greenpay_id;
	}

	public void setGreenpay_id(String greenpay_id) {
		this.greenpay_id = greenpay_id;
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getRealamount() {
		return realamount;
	}

	public void setRealamount(float realamount) {
		this.realamount = realamount;
	}

	public String getOrderuid() {
		return orderuid;
	}

	public void setOrderuid(String orderuid) {
		this.orderuid = orderuid;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
