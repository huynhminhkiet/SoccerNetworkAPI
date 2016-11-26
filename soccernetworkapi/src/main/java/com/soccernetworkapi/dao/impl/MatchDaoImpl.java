package com.soccernetworkapi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;

import com.soccernetworkapi.bean.Match;
import com.soccernetworkapi.dao.MatchDao;
import com.soccernetworkapi.utils.DateUtils;

public class MatchDaoImpl extends BaseDaoImpl implements MatchDao {

	public MatchDaoImpl(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public ArrayList<Match> getAllMatches() {
		String sql = "SELECT `match`.*, `user`.username, field.field_name,`match`.`maximum_players`-COALESCE(sum(slot.quantity),0) - 1 as available_slots "
				+ "FROM `match` INNER JOIN user ON `match`.host_id = `user`.user_id "
				+ "INNER JOIN field ON `match`.field_id = field.field_id "
				+ "LEFT JOIN `slot` ON match.match_id=slot.match_id "
				+ "GROUP BY match.match_id";
				
		return (ArrayList<Match>) jdbcTemplate.query(sql, new MatchMapper());
	}

	@Override
	public Match getMatchById(int id) {
		String sql = "SELECT `match`.*, `user`.username, field.field_name,`match`.`maximum_players`-COALESCE(sum(slot.quantity),0) - 1 as available_slots "
				+ "FROM `match` INNER JOIN user ON `match`.host_id = `user`.user_id "
				+ "INNER JOIN field ON `match`.field_id = field.field_id "
				+ "LEFT JOIN `slot` ON match.match_id=slot.match_id "
				+ "WHERE match.match_id = ? GROUP BY match.match_id";
		
		try {
			Match match = jdbcTemplate.queryForObject(sql, new Object[] {id}, new MatchMapper());
			return match;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Match getMatchByUserId(int id) {
		String sql = "SELECT `match`.*, `user`.username, field.field_name "
				+ "FROM `match` INNER JOIN user ON `match`.host_id = `user`.user_id "
				+ "INNER JOIN field ON `match`.field_id = field.field_id "
				+ "WHERE `match`.host_id = ?";
		try {
			Match match = jdbcTemplate.queryForObject(sql, new Object[] {id}, new MatchMapper());
			return match;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int createMatch(Match match) {
		String SQL = "INSERT INTO `match`(`field_id`, `host_id`, `status`, `maximum_players`, `price`, "
				+ "`start_time`, `end_time`, `is_verified`, `verification_code`) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)";
	    try {
	    	 return jdbcTemplate.update( SQL, match.getFieldId(), match.getHostId(), match.getStatus(),
	    			 match.getMaxPlayers(), match.getPrice(), DateUtils.convertToTimestamp(match.getStartTime()),
	    			 DateUtils.convertToTimestamp(match.getEndTime()), match.isVerified(), match.getVerificationCode());
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    }
	    return 0;
	}

	@Override
	public int updateMatch(Match match) {
		String SQL = "UPDATE `match` SET `field_id` = ?, `host_id` = ?, `status` = ?, `maximum_players` = ?, "
				+ "`price` = ?, `start_time` = ?, `end_time` = ?, `is_verified` = ?, `verification_code` = ? "
				+ "WHERE match_id = ?";
	    try {
	    	 return jdbcTemplate.update( SQL, match.getFieldId(), match.getHostId(), match.getStatus(),
	    			 match.getMaxPlayers(), match.getPrice(), DateUtils.convertToTimestamp(match.getStartTime()),
	    			 DateUtils.convertToTimestamp(match.getEndTime()), match.isVerified(), match.getVerificationCode(),
	    			 match.getMatchId());
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    }
	    return 0;
	}

	@Override
	public int deleteMatch(int id) {
		String SQL = "DELETE FROM `match` WHERE match_id = ?";
	    try {
	    	return jdbcTemplate.update(SQL, new Object[] {id});
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    }
	    return 0;
	}
	
	public class MatchMapper implements RowMapper<Match> {

		@Override
		public Match mapRow(ResultSet rs, int rowNum) throws SQLException {
			Match match = new Match(rs.getInt("match_id"), rs.getInt("field_id"), rs.getString("field_name"), 
					rs.getInt("host_id"), rs.getString("username"), rs.getInt("status"), rs.getInt("maximum_players"), 
					rs.getInt("available_slots"), rs.getInt("price"), DateUtils.formatDatetime(rs.getTimestamp("start_time")), 
					DateUtils.formatDatetime(rs.getTimestamp("end_time")), rs.getBoolean("is_verified"), rs.getString("verification_code"));
			return match;
		}
	}

}
