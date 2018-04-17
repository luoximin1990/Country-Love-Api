package com.marykay.country.love.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marykay.country.love.model.PhoneCode;

@Repository
public interface PhoneCodeRepository extends JpaRepository<PhoneCode, Integer> {

}
