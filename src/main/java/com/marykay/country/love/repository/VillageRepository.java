package com.marykay.country.love.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marykay.country.love.model.Village;

@Repository
public interface VillageRepository extends JpaRepository<Village, Integer> {

	List<Village> findByTownId(long townId);
}
