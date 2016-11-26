package com.soccernetworkapi.bean;

public class Slot {
	private int matchId;
	private int userId;
	private String username;
	private int quantity;
	private boolean isVerified;
	private String verificationCode;
	
	public Slot(int matchId, int userId, String username, int quantity, boolean isVerified, String verificationCode) {
		super();
		this.matchId = matchId;
		this.userId = userId;
		this.username = username;
		this.quantity = quantity;
		this.isVerified = isVerified;
		this.verificationCode = verificationCode;
	}

	public Slot(int userId, String username, int quantity, boolean isVerified, String verificationCode) {
		super();
		this.userId = userId;
		this.username = username;
		this.quantity = quantity;
		this.isVerified = isVerified;
		this.verificationCode = verificationCode;
	}
	
	public Slot() {}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
