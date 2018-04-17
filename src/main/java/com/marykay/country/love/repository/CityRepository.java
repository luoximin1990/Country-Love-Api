package com.marykay.country.love.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marykay.country.love.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

	List<City> findByProvinceId(int provinceId);
}
