package com.soccernetworkapi.dao;

import java.util.ArrayList;

import com.soccernetworkapi.bean.User;

public interface UserDao {
	ArrayList<User> getAllUsers();
	User getUserById(int id);
	int createUser(User user);
	int updateUser(User user);
	int deleteUser(int id);
	Integer checkUsernameExist(String username);
}
