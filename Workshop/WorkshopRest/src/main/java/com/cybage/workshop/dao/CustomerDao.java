package com.cybage.workshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.workshop.entity.Address;
import com.cybage.workshop.entity.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
	Customer findCustomerByName(String Name);
	Customer findCustomerByEmail(String email);
	void save(Address address);
}
