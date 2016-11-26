package com.soccernetworkapi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;

import com.soccernetworkapi.bean.City;
import com.soccernetworkapi.dao.CityDao;

public class CityDaoImpl extends BaseDaoImpl implements CityDao{	
	
	public CityDaoImpl(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public ArrayList<City> getAllCities() {
		String sql = "SELECT * FROM city";
		ArrayList<City> citys = new ArrayList<City>();
		citys = (ArrayList<City>) jdbcTemplate.query(sql, new CityMapper());
		return citys;
	}
	
	
	public class CityMapper implements RowMapper<City> {

		@Override
		public City mapRow(ResultSet rs, int rowNum) throws SQLException {
			City city = new City();
			city.setId(rs.getInt("city_id"));
			city.setCityCode(rs.getString("city_code"));
			city.setCityName(rs.getString("city_name"));
			return city;
		}
	}

	@Override
	public City getCityById(int id) {
		String sql = "SELECT * FROM city WHERE city_id = ?";
		try {
			City city = jdbcTemplate.queryForObject(sql, new Object[] {id}, new CityMapper());
			return city;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int createCity(City city) {
		String SQL = "INSERT INTO city(city_code, city_name) values (?, ?)";
	    try {
	    	 return jdbcTemplate.update( SQL, city.getCityCode(), city.getCityName());
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    }
	    return 0;
	}

	@Override
	public int updateCity(City city) {
		String SQL = "UPDATE `city` SET `city_code`=?,`city_name`=? WHERE `city_id`=?";
	    try {
	    	 return jdbcTemplate.update( SQL, city.getCityCode(), city.getCityName(), city.getId());
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    }
	    return 0;
	}

	@Override
	public int deleteCity(int cityId) {
		String SQL = "DELETE FROM `city` WHERE city_id = ?";
	    try {
	    	return jdbcTemplate.update(SQL, new Object[] {cityId});
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    }
	    return 0;
	}

}
