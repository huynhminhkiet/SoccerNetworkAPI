package com.soccernetworkapi.dao;

import java.util.ArrayList;

import com.soccernetworkapi.bean.MatchFeedback;

public interface MatchFeedbackDao {
	ArrayList<MatchFeedback> getAllFeedbacks();
	ArrayList<MatchFeedback> getAllFeedbacksByMatch(int matchId);
	int createFeedback(MatchFeedback feedback);
	int deleteFeedback(int matchId, int userId);
}
