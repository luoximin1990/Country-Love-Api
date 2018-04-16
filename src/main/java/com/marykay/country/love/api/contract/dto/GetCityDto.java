package com.marykay.country.love.api.contract.dto;

public class GetCityDto {

	// 城市ID
	private long cityId;
	// 城市名称
	private String cityName;

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
