package com.soccernetworkapi.bean.service;

public class DistrictJson {
	private int districtId;
	private String districtCode;
	private String districtName;
	private int cityId;
	private String cityName;
	
	public DistrictJson(int districtId, String districtCode, String districtName, int cityId, String cityName) {
		super();
		this.districtId = districtId;
		this.districtCode = districtCode;
		this.districtName = districtName;
		this.cityId = cityId;
		this.cityName = cityName;
	}

	public DistrictJson() {
		super();
	}

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

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "DistrictResponse [districtId=" + districtId + ", districtCode=" + districtCode + ", districtName="
				+ districtName + ", cityCode=" + cityId + ", cityName=" + cityName + "]";
	}
	
}
