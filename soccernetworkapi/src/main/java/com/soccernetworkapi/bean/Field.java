package com.soccernetworkapi.bean;

public class Field {
	private int fieldId;
	private String fieldName;
	private int districtId;
	private String districtName;
	private String address;
	private double latitude;
	private double longitude;
	private String phoneNumber;
	
	public Field(int fieldId, String fieldName, int districtId, String districtName, String address, double latitude,
			double longitude, String phoneNumber) {
		super();
		this.fieldId = fieldId;
		this.fieldName = fieldName;
		this.districtId = districtId;
		this.districtName = districtName;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.phoneNumber = phoneNumber;
	}

	public Field(String fieldName, int districtId, String districtName, String address, double latitude,
			double longitude, String phoneNumber) {
		super();
		this.fieldName = fieldName;
		this.districtId = districtId;
		this.districtName = districtName;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.phoneNumber = phoneNumber;
	}
	
	public Field() {}

	public int getFieldId() {
		return fieldId;
	}

	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
