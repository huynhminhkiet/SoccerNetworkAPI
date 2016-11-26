package com.soccernetworkapi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;

import com.soccernetworkapi.bean.Slot;
import com.soccernetworkapi.dao.SlotDao;

public class SlotDaoImpl extends BaseDaoImpl implements SlotDao{

	public SlotDaoImpl(DataSource dataSource) {
		super(dataSource);
	}
	
	public class SlotMapper implements RowMapper<Slot> {

		@Override
		public Slot mapRow(ResultSet rs, int rowNum) throws SQLException {
			Slot slot = new Slot(rs.getInt("match_id"), rs.getInt("user_id"), rs.getString("username"), 
					rs.getInt("quantity"), rs.getBoolean("is_verified"), rs.getString("verification_code"));
			return slot;
		}
	}

	@Override
	public ArrayList<Slot> getAllSlots() {
		String sql = "SELECT slot.*, user.username "
				+ "FROM slot INNER JOIN user ON slot.user_id = user.user_id";
		
		return (ArrayList<Slot>) jdbcTemplate.query(sql, new SlotMapper());
	}

	@Override
	public Slot getSlotById(int matchId, int userId) {
		String sql = "SELECT slot.*, user.username "
				+ "FROM slot INNER JOIN user ON slot.user_id = user.user_id  "
				+ "WHERE slot.match_id = ? AND slot.user_id = ?";
		
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] {matchId, userId}, new SlotMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int createSlot(Slot slot) {
		String SQL = "INSERT INTO `slot`(`match_id`, `user_id`, `quantity`, `is_verified`, `verification_code`) "
				+ "VALUES (?,?,?,?,?)";
	    try {
	    	 return jdbcTemplate.update( SQL, slot.getMatchId(), slot.getUserId(), slot.getQuantity(), slot.isVerified(), 
	    			 slot.getVerificationCode());
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    }
	    return 0;
	}

	@Override
	public int updateSlot(Slot slot) {
		String SQL = "UPDATE `slot` SET `quantity` = ?, `is_verified` = ?, `verification_code` = ? "
				+ "WHERE `match_id` = ? AND `user_id` = ?";
	    try {
	    	 return jdbcTemplate.update( SQL, slot.getQuantity(), slot.isVerified(), 
	    			 slot.getVerificationCode(), slot.getMatchId(), slot.getUserId());
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    }
	    return 0;
	}

	@Override
	public int deleteSlot(int matchId, int userId) {
		String SQL = "DELETE FROM slot WHERE match_id = ? AND user_id = ?";
	    try {
	    	return jdbcTemplate.update(SQL, new Object[] {matchId, userId});
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    }
	    return 0;
	}

	@Override
	public ArrayList<Slot> getSlotByMatchId(int matchId) {
		String sql = "SELECT slot.*, user.username "
				+ "FROM slot INNER JOIN user ON slot.user_id = user.user_id  "
				+ "WHERE slot.match_id = ?";
		try {
			return (ArrayList<Slot>) jdbcTemplate.query(sql,new Object[] {matchId} ,new SlotMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
