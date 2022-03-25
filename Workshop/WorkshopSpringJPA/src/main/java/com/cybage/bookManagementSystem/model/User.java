package com.cybage.bookManagementSystem.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	@OneToMany(mappedBy = "user")
	private List<Address>address;
	
	
	public User() {
		this.address=new ArrayList<>();
	}


	public User(int userId, @NotEmpty(message = "Enter User Name!!!") @Size(min = 8, max = 25) String name,
			@NotEmpty(message = "Enter User email!!!") @Size(min = 8, max = 25) String email,
			@Size(min = 8, max = 25) String password,
			@NotEmpty(message = "Enter User contact details!!!") @Size(min = 10, max = 12) String contact,
			List<Address> address) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.address = address;
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


	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	public void setAddress(Address address) {
		this.address.add(address);
		address.setUser(this);
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", contact=" + contact + ", address=" + address + "]";
	}


	

}
