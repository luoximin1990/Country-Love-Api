package com.marykay.country.love.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

@Entity(name = "j_position_provice")
@Table(name = "j_position_provice")
public class Provice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	// 省份编号
	private int proviceId;
	// 省份名称
	private String proviceName;
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

	public int getProviceId() {
		return proviceId;
	}

	public void setProviceId(int proviceId) {
		this.proviceId = proviceId;
	}

	public String getProviceName() {
		return proviceName;
	}

	public void setProviceName(String proviceName) {
		this.proviceName = proviceName;
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
