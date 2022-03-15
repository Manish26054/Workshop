package com.cybage.bookManagementSystem.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Credentials {

	@NotEmpty(message = "Enter User email!!!")
	@Size(min = 8,max = 25)
	private String email;
	
	@NotEmpty(message = "Enter password!!!")
	@Size(min = 8,max = 25)
	private String password;

	
	public Credentials() {
	}
	public Credentials(@NotEmpty(message = "Enter User email!!!") @Size(min = 8, max = 25) String email,
			@NotEmpty(message = "Enter password!!!") @Size(min = 8, max = 25) String password) {
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
		return "Credentials [email=" + email + ", password=" + password + "]";
	}
	
	
}
