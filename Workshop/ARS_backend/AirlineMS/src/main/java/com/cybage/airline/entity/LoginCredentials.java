package com.cybage.airline.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginCredentials {
	
	@NotBlank(message = "Email Cannot be blank!!!")
	private String email;
	
	@NotBlank(message = "password cannot be blank!!!")
	@Size(min = 8,max = 18)
	private String password;
	
	private String role;
	
	public LoginCredentials() {}

	public LoginCredentials(@NotBlank(message = "Email Cannot be blank!!!") String email,
			@NotBlank(message = "password cannot be blank!!!") @Size(min = 8, max = 18) String password, String role) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "LoginCredentials [email=" + email + ", password=" + password + ", role=" + role + "]";
	}

	
	
}
