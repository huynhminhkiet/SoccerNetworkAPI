package com.soccernetworkapi.dao;

import java.util.ArrayList;

import com.soccernetworkapi.bean.Field;

public interface FieldDao {
	ArrayList<Field> getAllFields();
	ArrayList<Field> getFieldsByDistrict(int districtId);
	Field getFieldById(int id);
	int createField(Field field);
	int updateField(Field field);
	int deleteField(int fieldId);
}
