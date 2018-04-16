package com.marykay.country.love.api.contract.response;

import java.util.List;
import com.marykay.country.love.api.contract.dto.GetUserDto;

public class GetUserListResponse extends PageableResponse {

	private List<GetUserDto> getUserDtoList;

	public List<GetUserDto> getGetUserDtoList() {
		return getUserDtoList;
	}

	public void setGetUserDtoList(List<GetUserDto> getUserDtoList) {
		this.getUserDtoList = getUserDtoList;
	}
}
