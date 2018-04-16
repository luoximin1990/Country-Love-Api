package com.marykay.country.love.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marykay.country.love.api.contract.dto.GetCityDto;
import com.marykay.country.love.api.contract.dto.GetCountryDto;
import com.marykay.country.love.api.contract.dto.GetProviceDto;
import com.marykay.country.love.api.contract.dto.GetTownDto;
import com.marykay.country.love.api.contract.dto.GetVillageDto;
import com.marykay.country.love.model.City;
import com.marykay.country.love.model.Country;
import com.marykay.country.love.model.Provice;
import com.marykay.country.love.model.Town;
import com.marykay.country.love.model.Village;
import com.marykay.country.love.repository.CityRepository;
import com.marykay.country.love.repository.CountryRepository;
import com.marykay.country.love.repository.ProviceRepository;
import com.marykay.country.love.repository.TownRepository;
import com.marykay.country.love.repository.VillageRepository;
import com.marykay.country.love.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService {

	@Autowired
	ProviceRepository proviceRepository;
	@Autowired
	CityRepository cityRepository;
	@Autowired
	CountryRepository countryRepository;
	@Autowired
	TownRepository townRepository;
	@Autowired
	VillageRepository villageRepository;

	@Override
	public List<GetProviceDto> getAllProvice() {

		List<GetProviceDto> getProviceDtoList = new ArrayList<>();
		List<Provice> proviceAll = proviceRepository.findAll();
		GetProviceDto getProviceDto = null;
		for (int i = 0; i < proviceAll.size(); i++) {
			getProviceDto = new GetProviceDto();
			getProviceDto.setProviceId(proviceAll.get(i).getProviceId());
			getProviceDto.setProviceName(proviceAll.get(i).getProviceName());
			getProviceDtoList.add(getProviceDto);
		}

		return getProviceDtoList;
	}

	@Override
	public List<GetCityDto> getAllCity(Integer proviceId) {
		List<GetCityDto> getCityDtoList = new ArrayList<>();
		List<City> cityAll = cityRepository.findByProviceId(proviceId);
		GetCityDto getCityDto = null;
		for (int i = 0; i < cityAll.size(); i++) {
			getCityDto = new GetCityDto();
			getCityDto.setCityId(cityAll.get(i).getCityId());
			getCityDto.setCityName(cityAll.get(i).getCityName());
			getCityDtoList.add(getCityDto);
		}

		return getCityDtoList;
	}

	@Override
	public List<GetCountryDto> getAllCountry(long cityId) {
		List<GetCountryDto> getCountryDtoList = new ArrayList<>();
		List<Country> countryAll = countryRepository.findByCityId(cityId);
		GetCountryDto getCountryDto = null;
		for (int i = 0; i < countryAll.size(); i++) {
			getCountryDto = new GetCountryDto();
			getCountryDto.setCountryId(countryAll.get(i).getCountryId());
			getCountryDto.setCountryName(countryAll.get(i).getCountyName());
			getCountryDtoList.add(getCountryDto);
		}

		return getCountryDtoList;
	}

	@Override
	public List<GetTownDto> getAllTown(long countryId) {
		List<GetTownDto> getTownDtoList = new ArrayList<>();
		List<Town> townAll = townRepository.findByCountryId(countryId);
		GetTownDto getTownDto = null;
		for (int i = 0; i < townAll.size(); i++) {
			getTownDto = new GetTownDto();
			getTownDto.setTownId(townAll.get(i).getTownId());
			getTownDto.setTownName(townAll.get(i).getTownName());
			getTownDtoList.add(getTownDto);
		}

		return getTownDtoList;
	}

	@Override
	public List<GetVillageDto> getAllVillage(long townId) {
		List<GetVillageDto> getVillageDtoList = new ArrayList<>();
		List<Village> villageAll = villageRepository.findByTownId(townId);
		GetVillageDto getVillageDto = null;
		for (int i = 0; i < villageAll.size(); i++) {
			getVillageDto = new GetVillageDto();
			getVillageDto.setVillageId(villageAll.get(i).getVillageId());
			getVillageDto.setVillageName(villageAll.get(i).getVillageName());
			getVillageDtoList.add(getVillageDto);
		}
		return getVillageDtoList;
	}

}
