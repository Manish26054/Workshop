package com.cybage.bookManagementSystem.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.beans.BeanUtils;

public class UserInDTO {
	
	private int userId;
	private String name;
	private String email;
	private String password;
	private String contact;
	private int pincode;
	private String street;
	private String city;
	private String state;
	
	
	public UserInDTO(int userId, String name, String email, String password, String contact, int pincode, String street,
			String city, String state) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.pincode = pincode;
		this.street = street;
		this.city = city;
		this.state = state;
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


	public int getPincode() {
		return pincode;
	}


	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}
	
	

	@Override
	public String toString() {
		return "UserInDTO [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", contact=" + contact + ", pincode=" + pincode + ", street=" + street + ", city=" + city + ", state="
				+ state + "]";
	}	
	
	public static User toEntity(UserInDTO userDTO) {
		User user= new User();
		BeanUtils.copyProperties(userDTO, user);
		user.setAddress(new Address(userDTO.pincode,userDTO.city,userDTO.street,userDTO.state));
		return user;
	}
	
}
