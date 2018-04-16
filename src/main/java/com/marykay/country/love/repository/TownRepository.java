package com.marykay.country.love.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marykay.country.love.model.Town;

@Repository
public interface TownRepository extends JpaRepository<Town, Integer> {

	List<Town> findByCountryId(long countryId);
}
