package com.marykay.country.love.api.contract.response;

import java.util.List;
import com.marykay.country.love.api.contract.dto.GetCityDto;

public class GetCityResponse {

	private List<GetCityDto> getCityDto;

	public List<GetCityDto> getGetCityDto() {
		return getCityDto;
	}

	public void setGetCityDto(List<GetCityDto> getCityDto) {
		this.getCityDto = getCityDto;
	}
}
