package com.marykay.country.love.api.contract.response;

import java.util.List;

import com.marykay.country.love.api.contract.dto.GetProviceDto;

public class GetProviceResponse {

	private List<GetProviceDto> getProviceDto;

	public List<GetProviceDto> getGetProviceDto() {
		return getProviceDto;
	}

	public void setGetProviceDto(List<GetProviceDto> getProviceDto) {
		this.getProviceDto = getProviceDto;
	}

}
