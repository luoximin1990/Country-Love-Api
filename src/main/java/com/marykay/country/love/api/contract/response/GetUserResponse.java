package com.marykay.country.love.api.contract.response;

import com.marykay.country.love.api.contract.dto.GetUserDto;

public class GetUserResponse {

	private GetUserDto getUserDto;

	public GetUserDto getGetUserDto() {
		return getUserDto;
	}

	public void setGetUserDto(GetUserDto getUserDto) {
		this.getUserDto = getUserDto;
	}

}
