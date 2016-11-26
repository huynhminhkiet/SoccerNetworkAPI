package com.soccernetworkapi.service;

import java.util.ArrayList;

import com.soccernetworkapi.bean.Match;
import com.soccernetworkapi.bean.service.StatusRespone;

public interface MatchService {
	ArrayList<Match> getAllMatches();
	Match getMatchById(int id);
	Match getMatchByUserId(int userId);
	StatusRespone createMatch(Match match);
	StatusRespone updateMatch(Match match);
	StatusRespone deleteMatch(int id);
}
