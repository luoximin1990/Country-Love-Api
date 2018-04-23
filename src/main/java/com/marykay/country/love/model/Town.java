package com.marykay.country.love.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "j_position_town")
@Table(name = "j_position_town")
public class Town {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	// 地区编号
	private long countryId;
	// 乡镇编号
	private long townId;
	// 乡镇名称
	private String townName;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getCountryId() {
		return countryId;
	}
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	public long getTownId() {
		return townId;
	}
	public void setTownId(long townId) {
		this.townId = townId;
	}
	public String getTownName() {
		return townName;
	}
	public void setTownName(String townName) {
		this.townName = townName;
	}
}
