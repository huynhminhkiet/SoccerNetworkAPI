package com.soccernetworkapi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;

import com.soccernetworkapi.bean.User;
import com.soccernetworkapi.dao.UserDao;
import com.soccernetworkapi.utils.DateUtils;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	public UserDaoImpl(DataSource dataSource) {
		super(dataSource);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<User> getAllUsers() {
		String sql = "SELECT user.*, district.district_name FROM user INNER JOIN district ON user.district_id = district.district_id";
		return (ArrayList<User>) jdbcTemplate.query(sql, new UserMapper());
	}

	@Override
	public User getUserById(int id) {
		String sql = "SELECT user.*, district.district_name FROM user INNER JOIN district ON user.district_id = district.district_id "
				+ "WHERE user.user_id = ?";
		try {
			User user = jdbcTemplate.queryForObject(sql, new Object[] {id}, new UserMapper());
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteUser(int id) {
		String SQL = "DELETE FROM user WHERE user_id = ?";
	    try {
	    	return jdbcTemplate.update(SQL, new Object[] {id});
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    }
	    return 0;
	}

	public class UserMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("password"), 
					rs.getString("email"), rs.getString("phone_number"), rs.getInt("status"), rs.getInt("district_id"), rs.getString("district_name"),
					rs.getInt("user_type"), DateUtils.formatDatetime(rs.getTimestamp("last_login")), rs.getBoolean("is_verified"), rs.getString("verification_code"));
			return user;
		}
		
	}

	@Override
	public int createUser(User user) {
		String SQL = "INSERT INTO user(username, password, email, phone_number, status,"
				+ " district_id, user_type, last_login, is_verified, verification_code) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
	    try {
	    	 return jdbcTemplate.update( SQL, user.getUsername(), user.getPassword(), user.getEmail(),
	    			 user.getPhoneNumber(), user.getStatus(), user.getDistrictId(), user.getUserType(),
	    			 DateUtils.convertToTimestamp(user.getLastLogin()), user.isVerified(),
	    			 user.getVerificationCode());
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    }
	    return 0;
	}


	@Override
	public int updateUser(User user) {
		String SQL = "UPDATE user SET username = ?, password = ?, email = ?, "
				+ "phone_number = ?, status = ?, district_id = ?, user_type = ?,"
				+ "last_login = ?, is_verified = ?, verification_code = ? "
				+ "WHERE user_id = ?";
	    try {
	    	 return jdbcTemplate.update(SQL, user.getUsername(), user.getPassword(), user.getEmail(),
	    			 user.getPhoneNumber(), user.getStatus(), user.getDistrictId(), user.getUserType(),
	    			 DateUtils.convertToTimestamp(user.getLastLogin()), user.isVerified(),
	    			 user.getVerificationCode(), user.getUserId());
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    }
	    return 0;
	}

	@Override
	public Integer checkUsernameExist(String username) {
		String sql = "SELECT COUNT(*) FROM user WHERE user.username = ?";
		return jdbcTemplate.queryForObject(sql,new Object[] {username}, Integer.class);
	}

}
