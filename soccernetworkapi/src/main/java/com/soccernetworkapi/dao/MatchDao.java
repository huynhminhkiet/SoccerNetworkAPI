package com.soccernetworkapi.dao;

import java.util.ArrayList;

import com.soccernetworkapi.bean.Match;

public interface MatchDao {
	ArrayList<Match> getAllMatches();
	Match getMatchById(int id);
	Match getMatchByUserId(int id);
	int createMatch(Match match);
	int updateMatch(Match match);
	int deleteMatch(int id);
}
