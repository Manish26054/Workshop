package com.cybage.airline.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.airline.entity.User;
import com.cybage.airline.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User authentication(String email, String password) {
		User user = userRepo.findByEmail(email);
		if (user != null && user.getPassword().equals(password))
			return user;
		return null;
	}

	@Override
	public User registerNewUser(User user) {
		User newUser = new User();
		user.setRole("customer");
		BeanUtils.copyProperties(user, newUser);
		return userRepo.save(newUser);
	}

	@Override
	public User findByEmail(String userEmail) {
		return userRepo.findByEmail(userEmail);
	}
}
