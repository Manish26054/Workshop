package com.cybage.bookManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.bookManagementSystem.dao.UserDao;
import com.cybage.bookManagementSystem.model.User;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;


	public void addUser(User user) {
		if(user!=null)
			userDao.save(user);
	}


	public User authentication(String email, String password) {
		User user = userDao.findByEmail(email);
		if(user!=null && user.getPassword().equals(password))
			return user;
		return null;
	}

}
