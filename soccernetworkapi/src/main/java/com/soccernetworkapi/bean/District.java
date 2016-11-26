package com.soccernetworkapi.bean;

public class District {
	private int districtId;
	private String districtCode;
	private String districtName;
	private int cityId;
	
	public District(int districtId, String districtCode, String districtName, int cityId) {
		super();
		this.districtId = districtId;
		this.districtCode = districtCode;
		this.districtName = districtName;
		this.cityId = cityId;
	}

	public District(String districtCode, String districtName, int cityId) {
		super();
		this.districtCode = districtCode;
		this.districtName = districtName;
		this.cityId = cityId;
	}
	
	public District() {}

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	@Override
	public String toString() {
		return "District [districtId=" + districtId + ", districtCode=" + districtCode + ", districtName="
				+ districtName + ", cityCode=" + cityId + "]";
	}
}
