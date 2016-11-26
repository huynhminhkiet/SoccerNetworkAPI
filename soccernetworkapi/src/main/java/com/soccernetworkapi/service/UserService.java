package com.soccernetworkapi.service;


import java.util.ArrayList;

import com.soccernetworkapi.bean.User;
import com.soccernetworkapi.bean.service.StatusRespone;

public interface UserService {
	ArrayList<User> getUsers();
	User getUserById(int id);
	StatusRespone createUser(User user);
	StatusRespone updateUser(User user);
	StatusRespone deleteUser(int id);
	StatusRespone checkUserExist(String username);
}
