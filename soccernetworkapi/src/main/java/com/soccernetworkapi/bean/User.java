package com.soccernetworkapi.bean;


public class User {
	private int userId;
	private String username;
	private String password;
	private String email;
	private String phoneNumber;
	private int status;
	private int districtId;
	private String districtName;
	private int userType;
	private String lastLogin;
	private boolean isVerified;
	private String verificationCode;
	
	public User(int userId, String username, String password, String email, String phoneNumber, int status,
			int districtId, String districtName, int userType, String lastLogin, boolean isVerified, String verificationCode) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.districtId = districtId;
		this.districtName = districtName;
		this.userType = userType;
		this.lastLogin = lastLogin;
		this.isVerified = isVerified;
		this.verificationCode = verificationCode;
	}

	public User(String username, String password, String email, String phoneNumber, int status, int districtId,
			String districtName, int userType, String lastLogin, boolean isVerified, String verificationCode) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.districtId = districtId;
		this.districtName = districtName;
		this.userType = userType;
		this.lastLogin = lastLogin;
		this.isVerified = isVerified;
		this.verificationCode = verificationCode;
	}

	public User() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	
	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", status=" + status + ", districtId=" + districtId + ", userType="
				+ userType + ", lastLogin=" + lastLogin + ", isVerified=" + isVerified + ", verificationCode="
				+ verificationCode + "]";
	}
	
}