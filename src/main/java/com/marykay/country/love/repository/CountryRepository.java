package com.marykay.country.love.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marykay.country.love.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

	List<Country> findByCityId(long cityId);
}
