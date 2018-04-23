package com.marykay.country.love.api.contract.request;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

public class PayRequest {

	// 手机号
	@NotBlank
	private String mobile;

	// 价格
	@NotNull
	private float amount;

	// 支付渠道 1：支付宝；2：微信支付（暂不支持）
	@NotNull
	private int type;

	// 通知回调网址
	@NotBlank
	private String notifyurl;

	// 跳转网址
	@NotBlank
	private String returnurl;

	// 商户自定义订单号
	@NotBlank
	private String ordernum;

//	// 商户自定义客户号
//	private String orderuid;

	// 商品名称
	private String goodname;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getNotifyurl() {
		return notifyurl;
	}

	public void setNotifyurl(String notifyurl) {
		this.notifyurl = notifyurl;
	}

	public String getReturnurl() {
		return returnurl;
	}

	public void setReturnurl(String returnurl) {
		this.returnurl = returnurl;
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

//	public String getOrderuid() {
//		return orderuid;
//	}
//
//	public void setOrderuid(String orderuid) {
//		this.orderuid = orderuid;
//	}

	public String getGoodname() {
		return goodname;
	}

	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
}
