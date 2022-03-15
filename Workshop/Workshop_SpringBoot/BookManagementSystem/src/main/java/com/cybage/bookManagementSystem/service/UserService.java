package com.cybage.bookManagementSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cybage.bookManagementSystem.model.User;


@Service
public class UserService {

	
List<User>userList=new ArrayList<User>();
	
	public UserService() {
		userList.add(new User(26054,"Manish","manish@cybage.com","manish@123","8871408573"));
		userList.add(new User(26055,"Anish","anish@cybage.com","anish@123","8871408575"));
		userList.add(new User(26056,"Rashmi","rashmi@cybage.com","rashmi@123","8871408576"));
		userList.add(new User(26057,"Meghna","meghna@cybage.com","meghna@123","8871408577"));
	}


	public User authentication(String email, String password) {
		User user1 = userList.stream().filter(user->user.getEmail().matches(email)).findFirst().orElse(null);
		if(user1!=null&& user1.getEmail().equals(email)&& user1.getPassword().equals(password)) {
			return user1;
		}
			
		return null;
	}
	

}
