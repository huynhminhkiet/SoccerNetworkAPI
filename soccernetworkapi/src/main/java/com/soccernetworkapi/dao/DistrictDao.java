package com.soccernetworkapi.dao;

import java.util.ArrayList;

import com.soccernetworkapi.bean.District;
import com.soccernetworkapi.bean.service.DistrictJson;

public interface DistrictDao {
	ArrayList<DistrictJson> getAllDistrict();
	DistrictJson getDistrictById(int id);
	int createDistrict(District district);
	int updateDistrict(District district);
	int deleteDistrict(int districtId);
}
