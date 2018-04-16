package com.marykay.country.love.api.contract.dto;

public class GetTownDto {

	// 乡镇编号
	private long townId;
	// 乡镇名称
	private String townName;

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
