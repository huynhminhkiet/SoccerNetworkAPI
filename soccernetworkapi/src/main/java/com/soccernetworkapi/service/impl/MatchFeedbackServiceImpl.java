package com.soccernetworkapi.service.impl;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soccernetworkapi.bean.MatchFeedback;
import com.soccernetworkapi.bean.service.StatusRespone;
import com.soccernetworkapi.dao.MyDataSource;
import com.soccernetworkapi.dao.impl.MatchFeedbackDaoImpl;
import com.soccernetworkapi.service.MatchFeedbackService;

@RestController
public class MatchFeedbackServiceImpl implements MatchFeedbackService{
	private MatchFeedbackDaoImpl feedbackDaoImpl = new MatchFeedbackDaoImpl(MyDataSource.getInstance().getDataSource());

	@Override
	@RequestMapping(value = "/feedbacks", method = RequestMethod.GET, headers = "Accept=application/json")
	public ArrayList<MatchFeedback> getAllFeedbacks() {
		return feedbackDaoImpl.getAllFeedbacks();
	}

	@Override
	@RequestMapping(value = "/feedbacks/{matchId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ArrayList<MatchFeedback> getAllFeedbacksByMatch(@PathVariable int matchId) {
		return feedbackDaoImpl.getAllFeedbacksByMatch(matchId);
	}

	@Override
	@RequestMapping(value = "/feedbacks", method = RequestMethod.POST, headers = "Accept=application/json")
	public StatusRespone createFeedback(@RequestBody MatchFeedback feedback) {
		StatusRespone statusRespone = new StatusRespone("fail");
		if (feedbackDaoImpl.createFeedback(feedback) == 1) {
			statusRespone.setStatus("success");
		} 
		return statusRespone;
	}

	@Override
	@RequestMapping(value = "/feedbacks/{matchId}/{userId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public StatusRespone deleteFeedback(@PathVariable int matchId, @PathVariable int userId) {
		StatusRespone statusRespone = new StatusRespone("fail");
		if (feedbackDaoImpl.deleteFeedback(matchId, userId) == 1) {
			statusRespone.setStatus("success");
		} 
		return statusRespone;
	}

}
