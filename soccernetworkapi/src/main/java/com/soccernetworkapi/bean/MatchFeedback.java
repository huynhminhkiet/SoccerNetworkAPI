package com.soccernetworkapi.bean;

public class MatchFeedback {
	private int matchId;
	private int userId;
	private String username;
	private String feedback;
	private String createDate;
	
	public MatchFeedback(int matchId, int userId, String username, String feedback, String createDate) {
		super();
		this.matchId = matchId;
		this.userId = userId;
		this.username = username;
		this.feedback = feedback;
		this.createDate = createDate;
	}
	
	public MatchFeedback() {}

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

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	
}
