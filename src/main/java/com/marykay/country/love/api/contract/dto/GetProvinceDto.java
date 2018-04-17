package com.marykay.country.love.api.contract.dto;

public class GetProvinceDto {

	// 省份编号
	private int provinceId;
	// 省份名称
	private String provinceName;

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
}
