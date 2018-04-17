package com.marykay.country.love.api.contract.response;

import java.util.List;

import com.marykay.country.love.api.contract.dto.GetProvinceDto;

public class GetProvinceResponse {

	private List<GetProvinceDto> getProvinceDto;

	public List<GetProvinceDto> getGetProvinceDto() {
		return getProvinceDto;
	}

	public void setGetProvinceDto(List<GetProvinceDto> getProvinceDto) {
		this.getProvinceDto = getProvinceDto;
	}

}
