package com.marykay.country.love.service;

import java.util.List;

import com.marykay.country.love.api.contract.dto.GetCityDto;
import com.marykay.country.love.api.contract.dto.GetCountryDto;
import com.marykay.country.love.api.contract.dto.GetProvinceDto;
import com.marykay.country.love.api.contract.dto.GetTownDto;
import com.marykay.country.love.api.contract.dto.GetVillageDto;

public interface PositionService {

	List<GetProvinceDto> getAllProvince();
	
	List<GetCityDto> getAllCity(Integer provinceId);
	
	List<GetCountryDto> getAllCountry(long cityId);
	
	List<GetTownDto> getAllTown(long countryId);
	
	List<GetVillageDto> getAllVillage(long townId);
}
