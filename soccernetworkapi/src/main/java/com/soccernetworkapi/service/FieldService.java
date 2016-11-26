package com.soccernetworkapi.service;

import java.util.ArrayList;

import com.soccernetworkapi.bean.Field;
import com.soccernetworkapi.bean.service.StatusRespone;

public interface FieldService {
	ArrayList<Field> getAllFields();
	ArrayList<Field> getFieldsByDistrict(int districtId);
	Field getFieldById(int id);
	StatusRespone createField(Field field);
	StatusRespone updateField(Field field);
	StatusRespone deleteField(int fieldId);
 }
