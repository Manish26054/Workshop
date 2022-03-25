package com.cybage.workshop.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	
	@NotBlank(message = "Name cannot be blank!!!")
	private String name;
	
	
	private String email;
	
	
	@OneToMany(mappedBy ="customer",cascade = CascadeType.ALL)
	private List<Address>address;
	
	public Customer() {
	}

	public Customer(int customerId, @NotBlank(message = "Name cannot be blank!!!") String name, String email,
			List<Address> address) {
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.address = address;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + ", address=" + address
				+ "]";
	}


	
}
