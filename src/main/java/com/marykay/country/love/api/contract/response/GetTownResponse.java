package com.marykay.country.love.api.contract.response;

import java.util.List;
import com.marykay.country.love.api.contract.dto.GetTownDto;

public class GetTownResponse {

	private List<GetTownDto> getTownDto;

	public List<GetTownDto> getGetTownDto() {
		return getTownDto;
	}

	public void setGetTownDto(List<GetTownDto> getTownDto) {
		this.getTownDto = getTownDto;
	}
}
