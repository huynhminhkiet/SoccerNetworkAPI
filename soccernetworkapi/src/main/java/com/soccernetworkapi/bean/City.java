package com.soccernetworkapi.bean;

public class City {
	private int id;
	private String cityCode;
	private String cityName;
	
	public City(int id, String cityCode, String cityName) {
		super();
		this.id = id;
		this.cityCode = cityCode;
		this.cityName = cityName;
	}

	public City(String cityCode, String cityName) {
		super();
		this.cityCode = cityCode;
		this.cityName = cityName;
	}
	
	public City() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", cityCode=" + cityCode + ", cityName=" + cityName + "]";
	}
	
}
