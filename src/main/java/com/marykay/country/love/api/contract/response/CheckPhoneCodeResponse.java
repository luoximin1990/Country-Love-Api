package com.marykay.country.love.api.contract.response;

public class CheckPhoneCodeResponse {

	public CheckPhoneCodeResponse(Boolean isEquality) {
		this.isEquality = isEquality;
	}

	private Boolean isEquality;

	public Boolean getIsEquality() {
		return isEquality;
	}

	public void setIsEquality(Boolean isEquality) {
		this.isEquality = isEquality;
	}

}
