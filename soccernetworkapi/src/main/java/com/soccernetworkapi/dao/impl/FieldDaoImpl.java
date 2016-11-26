package com.soccernetworkapi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;

import com.soccernetworkapi.bean.Field;
import com.soccernetworkapi.dao.FieldDao;

public class FieldDaoImpl extends BaseDaoImpl implements FieldDao{

	public FieldDaoImpl(DataSource dataSource) {
		super(dataSource);
	}
	
	public class FieldMapper implements RowMapper<Field> {

		@Override
		public Field mapRow(ResultSet rs, int rowNum) throws SQLException {
			Field field = new Field(rs.getInt("field_id"), rs.getString("field_name"), 
					rs.getInt("district_id"), rs.getString("district_name"), rs.getString("address"), 
					rs.getDouble("latitude"), rs.getDouble("longitude"), rs.getString("phone_number"));
			return field;
		}
		
	}

	@Override
	public ArrayList<Field> getAllFields() {
		String sql = "SELECT field.*, district.district_name "
				+ "FROM field INNER JOIN district ON field.district_id = district.district_id";
		ArrayList<Field> fields = new ArrayList<Field>();
		fields = (ArrayList<Field>) jdbcTemplate.query(sql, new FieldMapper());
		return fields;
	}

	@Override
	public Field getFieldById(int id) {
		String sql = "SELECT field.*, district.district_name "
				+ "FROM field INNER JOIN district ON field.district_id = district.district_id "
				+ "WHERE field.field_id = ?";
		try {
			Field field = jdbcTemplate.queryForObject(sql, new Object[] {id}, new FieldMapper());
			return field;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Field> getFieldsByDistrict(int districtId) {
		String sql = "SELECT field.*, district.district_name "
				+ "FROM field INNER JOIN district ON field.district_id = district.district_id "
				+ "WHERE field.district_id = ?";
		ArrayList<Field> fields = new ArrayList<Field>();
		fields = (ArrayList<Field>) jdbcTemplate.query(sql,new Object[] {districtId}, new FieldMapper());
		return fields;
	}

	@Override
	public int createField(Field field) {
		String SQL = "INSERT INTO `field`(`field_name`, `district_id`, `address`, `latitude`, `longitude`, `phone_number`) VALUES (?,?,?,?,?,?)";
	    try {
	    	 return jdbcTemplate.update( SQL, field.getFieldName(), field.getDistrictId(), field.getAddress(),
	    			 field.getLatitude(), field.getLongitude(), field.getPhoneNumber());
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    }
	    return 0;
	}

	@Override
	public int updateField(Field field) {
		String SQL = "UPDATE `field` SET `field_name`=?,`district_id`=?,`address`=?,`latitude`=?,`longitude`=?,`phone_number`=? WHERE `field_id` = ?";
	    try {
	    	 return jdbcTemplate.update( SQL, field.getFieldName(), field.getDistrictId(), field.getAddress(),
	    			 field.getLatitude(), field.getLongitude(), field.getPhoneNumber(), field.getFieldId());
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    }
	    return 0;
	}

	@Override
	public int deleteField(int fieldId) {
		String SQL = "DELETE FROM `field` WHERE field_id = ?";
	    try {
	    	return jdbcTemplate.update(SQL, new Object[] {fieldId});
	    } catch (Exception e) {
	    	 e.printStackTrace();
	    }
	    return 0;
	}

}
