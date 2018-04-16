package com.marykay.country.love.api.contract.dto;

public class GetCountryDto {

	// 地区ID
	private long countryId;
	// 地区名称
	private String countryName;
	public long getCountryId() {
		return countryId;
	}
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
