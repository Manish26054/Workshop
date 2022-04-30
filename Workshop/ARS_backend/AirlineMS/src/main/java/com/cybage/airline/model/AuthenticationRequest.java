package com.cybage.airline.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthenticationRequest {
	@NotBlank(message = "Email Cannot be blank!!!")
	private String email;
	
	@NotBlank(message = "password cannot be blank!!!")
	@Size(min = 8,max = 18)
	private String password;
	
	public AuthenticationRequest() {}

	public AuthenticationRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginCredentials [email=" + email + ", password=" + password + "]";
	}
	
}
