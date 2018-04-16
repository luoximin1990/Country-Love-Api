package com.marykay.country.love.api.contract.response;

import java.util.List;
import com.marykay.country.love.api.contract.dto.GetVillageDto;

public class GetVillageResponse {

	private List<GetVillageDto> getVillageDto;

	public List<GetVillageDto> getGetVillageDto() {
		return getVillageDto;
	}

	public void setGetVillageDto(List<GetVillageDto> getVillageDto) {
		this.getVillageDto = getVillageDto;
	}

}
