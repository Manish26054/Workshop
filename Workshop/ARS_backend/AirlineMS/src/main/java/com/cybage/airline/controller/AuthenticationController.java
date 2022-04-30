package com.cybage.airline.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cybage.airline.entity.LoginCredentials;
import com.cybage.airline.entity.UserDetail;
import com.cybage.airline.model.AuthenticationRequest;
import com.cybage.airline.model.AuthenticationResponse;
import com.cybage.airline.service.UserServiceImpl;
import com.cybage.airline.utility.JWTUtil;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;





@RestController
public class AuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserServiceImpl userDetailsService;

	@Autowired
	private JWTUtil jwtTokenUtil;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getEmail(), authenticationRequest.getPassword()));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(token));
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDetail registrationForm) throws Exception {
		String userEmail=registrationForm.getEmail();
		if(userEmail!=null && !"".equals(userEmail)) {
			UserDetail checkUser=userDetailsService.findByEmail(userEmail);
			if(checkUser!=null) {
				throw new Exception("User with "+userEmail+" already exist !!!");
			}
		}
		UserDetail newUser = userDetailsService.save(registrationForm);
		
		return ResponseEntity.ok(newUser);
	}
}
