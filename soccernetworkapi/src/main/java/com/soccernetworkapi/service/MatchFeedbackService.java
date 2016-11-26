package com.soccernetworkapi.service;

import java.util.ArrayList;

import com.soccernetworkapi.bean.MatchFeedback;
import com.soccernetworkapi.bean.service.StatusRespone;

public interface MatchFeedbackService {
	ArrayList<MatchFeedback> getAllFeedbacks();
	ArrayList<MatchFeedback> getAllFeedbacksByMatch(int matchId);
	StatusRespone createFeedback(MatchFeedback feedback);
	StatusRespone deleteFeedback(int matchId, int userId);
}
