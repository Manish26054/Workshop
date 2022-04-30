package com.cybage.airline.service;

import java.util.List;

import com.cybage.airline.entity.User;

public interface UserService {

	List<User> findAll();

	User update(User user);

	boolean deleteUser(int id);

	User getUserById(int id);

	User findByEmail(String email);

	
}
