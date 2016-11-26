package com.soccernetworkapi.service;

import java.util.ArrayList;

import com.soccernetworkapi.bean.District;
import com.soccernetworkapi.bean.service.DistrictJson;
import com.soccernetworkapi.bean.service.StatusRespone;

public interface DistrictService {
	ArrayList<DistrictJson> getAllDistricts();
	DistrictJson getDistrictById(int id);
	StatusRespone createDistrict(District district);
	StatusRespone updateDistrict(District district);
	StatusRespone deleteDistrict(int districtId);
}
