package com.soccernetworkapi.service.impl;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soccernetworkapi.bean.Match;
import com.soccernetworkapi.bean.service.StatusRespone;
import com.soccernetworkapi.dao.MyDataSource;
import com.soccernetworkapi.dao.impl.MatchDaoImpl;
import com.soccernetworkapi.service.MatchService;

@RestController
public class MatchServiceImpl implements MatchService {

	private MatchDaoImpl matchDaoImpl = new MatchDaoImpl((MyDataSource.getInstance().getDataSource()));
	
	@Override
	@RequestMapping(value = "/matches", method = RequestMethod.GET, headers = "Accept=application/json")
	public ArrayList<Match> getAllMatches() {
		return matchDaoImpl.getAllMatches();
	}

	@Override
	@RequestMapping(value = "/matches/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Match getMatchById(@PathVariable int id) {
		return matchDaoImpl.getMatchById(id);
	}
	
	@Override
	@RequestMapping(value = "/matches/user/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Match getMatchByUserId(@PathVariable("id") int userId) {
		return matchDaoImpl.getMatchByUserId(userId);
	}

	@Override
	@RequestMapping(value = "/matches", method = RequestMethod.POST, headers = "Accept=application/json")
	public StatusRespone createMatch(@RequestBody Match match) {
		StatusRespone statusRespone = new StatusRespone("fail");
		if (matchDaoImpl.createMatch(match) == 1) {
			statusRespone.setStatus("success");
		} 
		return statusRespone;
	}

	@Override
	@RequestMapping(value = "/matches", method = RequestMethod.PUT, headers = "Accept=application/json")
	public StatusRespone updateMatch(@RequestBody Match match) {
		StatusRespone statusRespone = new StatusRespone("fail");
		if (matchDaoImpl.updateMatch(match) == 1) {
			statusRespone.setStatus("success");
		} 
		return statusRespone;
	}

	@Override
	@RequestMapping(value = "/matches/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public StatusRespone deleteMatch(@PathVariable int id) {
		StatusRespone statusRespone = new StatusRespone("fail");
		if (matchDaoImpl.deleteMatch(id) == 1) {
			statusRespone.setStatus("success");
		} 
		return statusRespone;
	}
	
}
