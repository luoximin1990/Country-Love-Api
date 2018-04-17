package com.marykay.country.love.api.contract.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class GetUserListRequest {

	@NotNull
	@Min(0)
	private Integer pageNo;
	@NotNull
	@Min(0)
	private Integer pageSize;

	private String address;

	private String sex;

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
