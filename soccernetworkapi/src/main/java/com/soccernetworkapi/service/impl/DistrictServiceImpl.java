package com.soccernetworkapi.service.impl;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soccernetworkapi.bean.District;
import com.soccernetworkapi.bean.service.DistrictJson;
import com.soccernetworkapi.bean.service.StatusRespone;
import com.soccernetworkapi.dao.MyDataSource;
import com.soccernetworkapi.dao.impl.DistrictDaoImpl;
import com.soccernetworkapi.service.DistrictService;

@RestController
public class DistrictServiceImpl implements DistrictService {

	private DistrictDaoImpl districtDaoImpl = new DistrictDaoImpl(MyDataSource.getInstance().getDataSource());
	
	@Override
	@RequestMapping(value = "/districts", method = RequestMethod.GET, headers = "Accept=application/json")
	public ArrayList<DistrictJson> getAllDistricts() {
		return districtDaoImpl.getAllDistrict() ;
	}

	@Override
	@RequestMapping(value = "/districts/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public DistrictJson getDistrictById(@PathVariable int id) {
		return districtDaoImpl.getDistrictById(id);
	}

	@Override
	@RequestMapping(value = "/districts", method = RequestMethod.POST, headers = "Accept=application/json")
	public StatusRespone createDistrict(@RequestBody District district) {
		StatusRespone statusRespone = new StatusRespone("fail");
		if (districtDaoImpl.createDistrict(district) == 1) {
			statusRespone.setStatus("success");
		} 
		return statusRespone;
	}

	@Override
	@RequestMapping(value = "/districts", method = RequestMethod.PUT, headers = "Accept=application/json")
	public StatusRespone updateDistrict(@RequestBody District district) {
		StatusRespone statusRespone = new StatusRespone("fail");
		if (districtDaoImpl.updateDistrict(district) == 1) {
			statusRespone.setStatus("success");
		} 
		return statusRespone;
	}

	@Override
	@RequestMapping(value = "/districts/{districtId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public StatusRespone deleteDistrict(@PathVariable int districtId) {
		StatusRespone statusRespone = new StatusRespone("fail");
		if (districtDaoImpl.deleteDistrict(districtId) == 1) {
			statusRespone.setStatus("success");
		} 
		return statusRespone;
	}

}
