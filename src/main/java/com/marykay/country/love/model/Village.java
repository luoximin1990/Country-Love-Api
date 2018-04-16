package com.marykay.country.love.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

@Entity(name = "j_position_village")
@Table(name = "j_position_village")
public class Village {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	// 乡镇编号
	private long townId;
	// 村编号
	private long villageId;
	// 村名称
	private String villageName;
	// 创建者
	private String createdBy;
	// 创建时间
	private Date createdDate;
	// 更新者
	private String updatedBy;
	// 更新时间
	private Date updatedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getTownId() {
		return townId;
	}

	public void setTownId(long townId) {
		this.townId = townId;
	}

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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
