package com.cybage.airline.service;

import com.cybage.airline.entity.User;

public interface UserService {


	User authentication(String email, String password);

	User registerNewUser(User user);

	User findByEmail(String userEmail);

}
