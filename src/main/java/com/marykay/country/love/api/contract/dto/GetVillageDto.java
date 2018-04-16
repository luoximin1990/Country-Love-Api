package com.marykay.country.love.api.contract.dto;

public class GetVillageDto {

	// 村编号
	private long villageId;
	// 村名称
	private String villageName;

	public long getVillageId() {
		return villageId;
	}
	public void setVillageId(long villageId) {
		this.villageId = villageId;
	}
	public String getVillageName() {
		return villageName;
	}
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

}
