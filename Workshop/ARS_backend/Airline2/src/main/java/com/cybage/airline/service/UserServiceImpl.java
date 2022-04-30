package com.cybage.airline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.airline.entity.User;
import com.cybage.airline.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	public User update(User user) {
		return userRepo.save(user);
	}

	public boolean deleteUser(int id) {
		if(userRepo.existsById(id)) {
			userRepo.deleteById(id);
			return true;
		}
		return false;
	}

	public User getUserById(int id) {
		Optional<User> user = userRepo.findById(id);
		return user.orElse(null);
	}

	@Override
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	
	
}
