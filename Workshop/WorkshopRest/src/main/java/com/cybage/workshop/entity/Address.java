package com.cybage.workshop.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private int address_id;
	private int pincode;
	private String street;
	private String city;
	private String state;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	private Customer customer;
	
	public Address() {
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

	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", pincode=" + pincode + ", street=" + street + ", city=" + city
				+ ", state=" + state + "]";
	}


	
	
}
