package com.marykay.country.love.service;

import java.util.List;

import com.marykay.country.love.api.contract.dto.GetCityDto;
import com.marykay.country.love.api.contract.dto.GetCountryDto;
import com.marykay.country.love.api.contract.dto.GetProviceDto;
import com.marykay.country.love.api.contract.dto.GetTownDto;
import com.marykay.country.love.api.contract.dto.GetVillageDto;

public interface PositionService {

	List<GetProviceDto> getAllProvice();
	
	List<GetCityDto> getAllCity(Integer proviceId);
	
	List<GetCountryDto> getAllCountry(long cityId);
	
	List<GetTownDto> getAllTown(long countryId);
	
	List<GetVillageDto> getAllVillage(long townId);
}
