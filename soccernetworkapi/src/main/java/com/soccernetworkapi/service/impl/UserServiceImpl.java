package com.soccernetworkapi.service.impl;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soccernetworkapi.bean.User;
import com.soccernetworkapi.bean.service.StatusRespone;
import com.soccernetworkapi.dao.MyDataSource;
import com.soccernetworkapi.dao.impl.UserDaoImpl;
import com.soccernetworkapi.service.UserService;


@RestController
public class UserServiceImpl implements UserService {

	UserDaoImpl userDaoImpl = new UserDaoImpl(MyDataSource.getInstance().getDataSource());

	@Override
	@RequestMapping(value = "/users", method = RequestMethod.GET, headers = "Accept=application/json")
	public ArrayList<User> getUsers() {
		ArrayList<User> users = userDaoImpl.getAllUsers();
		return users;
	}

	@Override
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getUserById(@PathVariable int id) {
		return userDaoImpl.getUserById(id);
	}
	
	@Override
	@RequestMapping(value = "/users", method = RequestMethod.POST, headers = "Accept=application/json")
	public StatusRespone createUser(@RequestBody User user) {
		StatusRespone statusRespone = new StatusRespone("fail");
		if (userDaoImpl.createUser(user) == 1) {
			statusRespone.setStatus("success");
		} 
		return statusRespone;
	}
	
	@Override
	@RequestMapping(value = "/users", method = RequestMethod.PUT, headers = "Accept=application/json")
	public StatusRespone updateUser(@RequestBody User user) {
		StatusRespone statusRespone = new StatusRespone("fail");
		if (userDaoImpl.updateUser(user) == 1) {
			statusRespone.setStatus("success");
		} 
		return statusRespone;
	}

	@Override
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public StatusRespone deleteUser(@PathVariable int id) {
		StatusRespone statusRespone = new StatusRespone("fail");
		if (userDaoImpl.deleteUser(id) == 1) {
			statusRespone.setStatus("success");
		} 
		return statusRespone;

	}

	@Override
	@RequestMapping(value = "/users/check-username-exist/{username}", method = RequestMethod.GET, headers = "Accept=application/json")
	public StatusRespone checkUserExist(@PathVariable String username) {
		StatusRespone statusRespone = new StatusRespone("false");
		if (userDaoImpl.checkUsernameExist(username) > 0) {
			statusRespone.setStatus("true");
		} 
		return statusRespone;
	}	
}
