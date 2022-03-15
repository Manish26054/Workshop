package com.cybage.bookManagementSystem.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;


public class User {
	
	@NotNull
	@Min(4)
	private int userId;
	
	@NotEmpty(message = "Enter User Name!!!")
	@Size(min = 8,max = 25)
	private String name;
	
	@NotEmpty(message = "Enter User email!!!")
	@Size(min = 8,max = 25)
	private String email;
	
	
	@Size(min = 8,max = 25)
	private String password;
	
	@NotEmpty(message = "Enter User contact details!!!")
	@Size(min = 10,max =12 )
	private String contact;
	
	public User() {
	}

	public User(@NotNull @Min(4) int userId,
			@NotEmpty(message = "Enter User Name!!!") @Size(min = 8, max = 25) String name,
			@NotEmpty(message = "Enter User email!!!") @Size(min = 8, max = 25) String email,
			@NotEmpty(message = "Enter password!!!") @Size(min = 8, max = 25) String password,
			@NotEmpty(message = "Enter User contact details!!!") @Size(min = 10, max = 12) String contact) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.contact = contact;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", contact=" + contact + "]";
	}
	
	
}
