package com.soccernetworkapi.service.impl;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soccernetworkapi.bean.City;
import com.soccernetworkapi.bean.service.StatusRespone;
import com.soccernetworkapi.dao.MyDataSource;
import com.soccernetworkapi.dao.impl.CityDaoImpl;
import com.soccernetworkapi.service.CityService;

@RestController
public class CityServiceImpl implements CityService {
	
	private CityDaoImpl cityDaoImpl = new CityDaoImpl(MyDataSource.getInstance().getDataSource());
	
	@Override
	@RequestMapping(value = "/cities", method = RequestMethod.GET, headers = "Accept=application/json")
	public ArrayList<City> getAllCities() {
		return cityDaoImpl.getAllCities();
	}

	@Override
	@RequestMapping(value = "/cities/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public City getCityById(@PathVariable int id) {
		return cityDaoImpl.getCityById(id);
	}

	@Override
	@RequestMapping(value = "/cities", method = RequestMethod.POST, headers = "Accept=application/json")
	public StatusRespone createDity(@RequestBody City city) {
		StatusRespone statusRespone = new StatusRespone("fail");
		 if (cityDaoImpl.createCity(city) == 1) {
			 statusRespone.setStatus("success");
		 }
		 return statusRespone;
	}

	@Override
	@RequestMapping(value = "/cities", method = RequestMethod.PUT, headers = "Accept=application/json")
	public StatusRespone updateCity(@RequestBody City city) {
		StatusRespone statusRespone = new StatusRespone("fail");
		if (cityDaoImpl.updateCity(city) == 1) {
			statusRespone.setStatus("success");
		} 
		return statusRespone;
	}

	@Override
	@RequestMapping(value = "/cities/{cityId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public StatusRespone deleteCity(@PathVariable int cityId) {
		StatusRespone statusRespone = new StatusRespone("fail");
		if (cityDaoImpl.deleteCity(cityId) == 1) {
			statusRespone.setStatus("success");
		} 
		return statusRespone;
	}

}
