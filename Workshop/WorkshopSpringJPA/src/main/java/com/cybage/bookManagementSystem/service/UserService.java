package com.cybage.bookManagementSystem.service;

import javax.validation.Valid;

import com.cybage.bookManagementSystem.model.User;

public interface UserService {

	User authentication(String email, String password);

	void addUser(@Valid User user);

}
