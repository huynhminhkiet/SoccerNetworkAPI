package com.soccernetworkapi.bean;

public class Match {
	private int matchId;
	private int fieldId;
	private String fieldName;
	private int hostId;
	private String hostName;
	private int status;
	private int maxPlayers;
	private int availableSlots;
	private int price;
	private String startTime;
	private String endTime;
	private boolean isVerified;
	private String verificationCode;
	
	public Match(int matchId, int fieldId, String fieldName, int hostId, String hostName, int status, int maxPlayers,
			int availableSlots, int price, String startTime, String endTime, boolean isVerified, String verificationCode) {
		super();
		this.matchId = matchId;
		this.fieldId = fieldId;
		this.fieldName = fieldName;
		this.hostId = hostId;
		this.hostName = hostName;
		this.status = status;
		this.maxPlayers = maxPlayers;
		this.availableSlots = availableSlots;
		this.price = price;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isVerified = isVerified;
		this.verificationCode = verificationCode;
	}

	public Match(int fieldId, String fieldName, int hostId, String hostName, int status, int maxPlayers, int availableSlots, int price,
			String startTime, String endTime, boolean isVerified, String verificationCode) {
		super();
		this.fieldId = fieldId;
		this.fieldName = fieldName;
		this.hostId = hostId;
		this.hostName = hostName;
		this.status = status;
		this.maxPlayers = maxPlayers;
		this.availableSlots = availableSlots;
		this.price = price;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isVerified = isVerified;
		this.verificationCode = verificationCode;
	}
	
	public int getAvailableSlots() {
		return availableSlots;
	}

	public void setAvailableSlots(int availableSlots) {
		this.availableSlots = availableSlots;
	}

	public Match() {}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

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

	public int getHostId() {
		return hostId;
	}

	public void setHostId(int hostId) {
		this.hostId = hostId;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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
	
}
