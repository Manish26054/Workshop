package com.cybage.airline.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user_detail")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	
	@Email
	@NotBlank
	private String email;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String gender;
	
	@NotBlank
	private String contact;
	
	private String role;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Feedback> feedback ;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Complain> complain;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<BookTicket> ticket;
	
	public User() {
		this.feedback=new ArrayList<>();
		this.complain=new ArrayList<>();
		this.ticket=new ArrayList<>();
	}

	public User(int userId, String firstName, String lastName, String email, String password, String gender,
			String contact, String role) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.contact = contact;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", gender=" + gender + ", contact=" + contact + ", role=" + role + "]";
	}


	
	
}
