package com.marykay.country.love.api.contract.dto;

public class GetProviceDto {

	// 省份编号
	private int proviceId;
	// 省份名称
	private String proviceName;

	public int getProviceId() {
		return proviceId;
	}

	public void setProviceId(int proviceId) {
		this.proviceId = proviceId;
	}

	public String getProviceName() {
		return proviceName;
	}

	public void setProviceName(String proviceName) {
		this.proviceName = proviceName;
	}
}
