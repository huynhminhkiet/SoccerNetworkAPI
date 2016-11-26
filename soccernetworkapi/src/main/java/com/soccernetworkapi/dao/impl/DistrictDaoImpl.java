package com.soccernetworkapi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;

import com.soccernetworkapi.bean.District;
import com.soccernetworkapi.bean.service.DistrictJson;
import com.soccernetworkapi.dao.DistrictDao;

public class DistrictDaoImpl extends BaseDaoImpl implements DistrictDao {

	public DistrictDaoImpl(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public ArrayList<DistrictJson> getAllDistrict() {
		String sql = "SELECT district.*, city.city_id, city.city_name "
				+ "FROM district INNER JOIN city ON district.city_id = city.city_id";
		
		return (ArrayList<DistrictJson>) jdbcTemplate.query(sql, new DistrictMapper());
	}
	
	public class DistrictMapper implements RowMapper<DistrictJson> {

		@Override
		public DistrictJson mapRow(ResultSet rs, int rowNum) throws SQLException {
			DistrictJson districtJson = new DistrictJson();
			districtJson.setDistrictId(rs.getInt("district_id"));
			districtJson.setDistrictCode(rs.getString("district_code"));
			districtJson.setDistrictName(rs.getString("district_name"));
			districtJson.setCityId(rs.getInt("city_id"));
			districtJson.setCityName(rs.getString("city_name"));
			return districtJson;
		}
		
	}

	@Override
	public DistrictJson getDistrictById(int id) {
		String sql = "SELECT district.*, city.city_id, city.city_name "
				+ "FROM district INNER JOIN city ON district.city_id = city.city_id "
				+ "WHERE district.district_id = ?";
		try {
			DistrictJson districtJson = jdbcTemplate.queryForObject(sql, new Object[] {id}, 
					new DistrictMapper());
			return districtJson;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int createDistrict(District district) {
		String SQL = "INSERT INTO `district`(`district_code`, `district_name`, `city_id`) "
				+ "VALUES (?,?,?)";
	    try {
	    	 return jdbcTemplate.update( SQL, district.getDistrictCode(), district.getDistrictName() , district.getCityId());
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    }
	    return 0;
	}

	@Override
	public int updateDistrict(District district) {
		String SQL = "UPDATE `district` SET `district_code`=?,`district_name`=?,`city_id`=? "
				+ "WHERE `district_id`=?";
	    try {
	    	 return jdbcTemplate.update( SQL, district.getDistrictCode(), district.getDistrictName(), district.getCityId(), district.getDistrictId());
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    }
	    return 0;
	}

	@Override
	public int deleteDistrict(int districtId) {
		String SQL = "DELETE FROM `district` WHERE district_id = ?";
	    try {
	    	return jdbcTemplate.update(SQL, new Object[] {districtId});
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    }
	    return 0;
	}

}
