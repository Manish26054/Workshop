package com.cybage.bookManagementSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int address_id;
private int pincode;
private String street;
private String city;
private String state;

@ManyToOne
@JoinColumn(name="userId",referencedColumnName = "userId")
private User user;

public Address() {
	this.user=new User();
}

public Address(int address_id, int pincode, String street, String city, String state) {
	this.address_id = address_id;
	this.pincode = pincode;
	this.street = street;
	this.city = city;
	this.state = state;	
}

public Address(int pincode, String city, String street, String state) {
	this.pincode = pincode;
	this.street = street;
	this.city = city;
	this.state = state;	
}

public int getAddress_id() {
	return address_id;
}

public void setAddress_id(int address_id) {
	this.address_id = address_id;
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



public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

@Override
public String toString() {
	return "Address [address_id=" + address_id + ", pincode=" + pincode + ", street=" + street + ", city=" + city
			+ ", state=" + state + ", user=" + user + "]";
}




}
