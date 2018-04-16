package com.marykay.country.love.api.contract.response;

import java.util.List;
import com.marykay.country.love.api.contract.dto.GetCountryDto;

public class GetCountryResponse {

	private List<GetCountryDto> getCountryDto;

	public List<GetCountryDto> getGetCountryDto() {
		return getCountryDto;
	}

	public void setGetCountryDto(List<GetCountryDto> getCountryDto) {
		this.getCountryDto = getCountryDto;
	}

}
