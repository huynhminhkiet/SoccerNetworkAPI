package com.soccernetworkapi.service;

import java.util.ArrayList;

import com.soccernetworkapi.bean.City;
import com.soccernetworkapi.bean.service.StatusRespone;

public interface CityService {
	ArrayList<City> getAllCities();
	City getCityById(int id);
	StatusRespone createDity(City city);
	StatusRespone updateCity(City city);
	StatusRespone deleteCity(int cityId);
}
