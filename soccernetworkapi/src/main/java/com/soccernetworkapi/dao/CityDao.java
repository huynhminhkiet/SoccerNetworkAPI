package com.soccernetworkapi.dao;

import java.util.ArrayList;

import com.soccernetworkapi.bean.City;

public interface CityDao {
	ArrayList<City> getAllCities();
	City getCityById(int id);
	int createCity(City city);
	int updateCity(City city);
	int deleteCity(int cityId);
}
