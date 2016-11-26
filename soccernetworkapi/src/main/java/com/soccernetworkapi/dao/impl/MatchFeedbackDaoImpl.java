package com.soccernetworkapi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;

import com.soccernetworkapi.bean.MatchFeedback;
import com.soccernetworkapi.dao.MatchFeedbackDao;
import com.soccernetworkapi.utils.DateUtils;

public class MatchFeedbackDaoImpl extends BaseDaoImpl implements MatchFeedbackDao{

	public MatchFeedbackDaoImpl(DataSource dataSource) {
		super(dataSource);
	}
	
	public class FeedbackMapper implements RowMapper<MatchFeedback> {

		@Override
		public MatchFeedback mapRow(ResultSet rs, int rowNum) throws SQLException {
			MatchFeedback feedback = new MatchFeedback(rs.getInt("match_id"), rs.getInt("user_id"), 
					rs.getString("username"), rs.getString("feedback"), DateUtils.formatDatetime(rs.getTimestamp("created_date")));
			return feedback;
		}
	}

	@Override
	public ArrayList<MatchFeedback> getAllFeedbacks() {
		String sql = "SELECT match_feedback.*, user.username "
				+ "FROM match_feedback INNER JOIN user ON match_feedback.user_id = user.user_id";
		ArrayList<MatchFeedback> matchFeedbacks = new ArrayList<MatchFeedback>();
		matchFeedbacks = (ArrayList<MatchFeedback>) jdbcTemplate.query(sql, new FeedbackMapper());
		return matchFeedbacks;
	}

	@Override
	public ArrayList<MatchFeedback> getAllFeedbacksByMatch(int matchId) {
		String sql = "SELECT match_feedback.*, user.username "
				+ "FROM match_feedback INNER JOIN user ON match_feedback.user_id = user.user_id "
				+ "WHERE match_feedback.match_id = ?";
		ArrayList<MatchFeedback> matchFeedbacks = new ArrayList<MatchFeedback>();
		matchFeedbacks = (ArrayList<MatchFeedback>) jdbcTemplate.query(sql, new Object[] {matchId}, new FeedbackMapper());
		return matchFeedbacks;
	}

	@Override
	public int createFeedback(MatchFeedback feedback) {
		String SQL = "INSERT INTO `match_feedback`(`match_id`, `user_id`, `feedback`, `created_date`) VALUES (?,?,?,?)";
	    try {
	    	 return jdbcTemplate.update( SQL, feedback.getMatchId(), feedback.getUserId(), feedback.getFeedback(), DateUtils.convertToTimestamp(new Date()));
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    }
	    return 0;
	}

	@Override
	public int deleteFeedback(int matchId, int userId) {
		String SQL = "DELETE FROM match_feedback WHERE match_id = ? AND user_id = ?";
	    try {
	    	return jdbcTemplate.update(SQL, new Object[] {matchId, userId});
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    }
	    return 0;
	}

}
