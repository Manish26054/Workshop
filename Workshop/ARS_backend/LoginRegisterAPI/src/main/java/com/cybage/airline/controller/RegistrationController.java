package com.cybage.airline.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.airline.entity.User;
import com.cybage.airline.service.UserService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class RegistrationController {
	private static final Logger log=LogManager.getLogger(RegistrationController.class);
	@Autowired
	UserService userService;
	
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody User regForm ) throws Exception{
		String userEmail=regForm.getEmail();
		log.info("User registration form data =>"+regForm);
		
		if(userEmail!=null && !"".equals(userEmail)) {
			User checkUser=userService.findByEmail(userEmail);
			if(checkUser!=null) {
				log.error("User entered email already exist=>"+userEmail);
				throw new Exception("User with "+userEmail+" already exist !!!");
			}
		}
		
		User newUser = userService.registerNewUser(regForm);
		log.info("Saved data in database=>"+newUser);
		return ResponseEntity.ok(newUser);
	}
	
}
