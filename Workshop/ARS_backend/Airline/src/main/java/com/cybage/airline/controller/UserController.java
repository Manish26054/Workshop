package com.cybage.airline.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cybage.airline.entity.User;
import com.cybage.airline.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserService userService;
	
	 @PostMapping("/process_register")
	    public String processRegister(User user, HttpServletRequest request)throws UnsupportedEncodingException, MessagingException {
	        userService.register(user, getSiteURL(request));       
	        return "register_success";
	    }
	     
	    private String getSiteURL(HttpServletRequest request) {
	        String siteURL = request.getRequestURL().toString();
	        return siteURL.replace(request.getServletPath(), "");
	    }  
	    @GetMapping("/verify")
	    public ResponseEntity<?> verifyUser(@Param("code") String code) {
	        if (userService.verify(code)) {
	            return ResponseEntity.ok("Verification successful !!!");
	        } else {
	          return (ResponseEntity<?>) ResponseEntity.badRequest();
	        }
	    }
}
