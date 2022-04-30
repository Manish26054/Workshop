package com.cybage.airline.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.airline.entity.User;
import com.cybage.airline.models.LoginCredentials;
import com.cybage.airline.service.UserService;

@RestController
@CrossOrigin("http://localhost:4200")
public class LoginController {
	
	private static final Logger log=LogManager.getLogger(LoginController.class);
	
	@Autowired
	private UserService loginService; 
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginCredentials credentials,HttpSession session) throws Exception{
		User user = loginService.authentication(credentials.getEmail(),credentials.getPassword());
		log.info("Customer entered credentials =>"+credentials);
		if(user!=null) {
			if(user.getRole().equals("admin")) {
				session.setAttribute("username",user.getFirstName());
				return ResponseEntity.ok(user);
			}
			else if(user.getRole().equals("customer")) {
				log.info("Customer has logged in !!!");
				session.setAttribute("username",user.getFirstName());
				return ResponseEntity.ok(user);
			}
		
		}else {
			log.error("Invalid user credentials !!!"+credentials);
			throw new Exception("Invalid User Credentials!!!");
		}
		return null;
	}
	
}
