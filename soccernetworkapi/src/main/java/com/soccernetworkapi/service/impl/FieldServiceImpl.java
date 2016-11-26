package com.soccernetworkapi.service.impl;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soccernetworkapi.bean.Field;
import com.soccernetworkapi.bean.service.StatusRespone;
import com.soccernetworkapi.dao.MyDataSource;
import com.soccernetworkapi.dao.impl.FieldDaoImpl;
import com.soccernetworkapi.service.FieldService;

@RestController
public class FieldServiceImpl implements FieldService {
	
	private FieldDaoImpl fieldDaoImpl = new FieldDaoImpl(MyDataSource.getInstance().getDataSource());

	@Override
	@RequestMapping(value = "/fields", method = RequestMethod.GET, headers = "Accept=application/json")
	public ArrayList<Field> getAllFields() {
		return fieldDaoImpl.getAllFields();
	}

	@Override
	@RequestMapping(value = "/fields/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Field getFieldById(@PathVariable int id) {
		return fieldDaoImpl.getFieldById(id);
	}

	@Override
	@RequestMapping(value = "/fields/district/{districtId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ArrayList<Field> getFieldsByDistrict(@PathVariable int districtId) {
		return fieldDaoImpl.getFieldsByDistrict(districtId);
	}

	@Override
	@RequestMapping(value = "/fields", method = RequestMethod.POST, headers = "Accept=application/json")
	public StatusRespone createField(@RequestBody Field field) {
		StatusRespone statusRespone = new StatusRespone("fail");
		if (fieldDaoImpl.createField(field) == 1) {
			statusRespone.setStatus("success");
		} 
		return statusRespone;
	}

	@Override
	@RequestMapping(value = "/fields", method = RequestMethod.PUT, headers = "Accept=application/json")
	public StatusRespone updateField(@RequestBody Field field) {
		StatusRespone statusRespone = new StatusRespone("fail");
		if (fieldDaoImpl.updateField(field) == 1) {
			statusRespone.setStatus("success");
		} 
		return statusRespone;
	}

	@Override
	@RequestMapping(value = "/fields/{fieldId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public StatusRespone deleteField(@PathVariable int fieldId) {
		StatusRespone statusRespone = new StatusRespone("fail");
		if (fieldDaoImpl.deleteField(fieldId) == 1) {
			statusRespone.setStatus("success");
		} 
		return statusRespone;
	}

}
