package com.cybage.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.workshop.dao.AddressDao;
import com.cybage.workshop.dao.CustomerDao;
import com.cybage.workshop.entity.Address;
import com.cybage.workshop.entity.Customer;

@Service
public class CustomerService {

	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private AddressDao addressDao;



	public void save(Customer customer) {
		customerDao.save(customer);
	}



	public List<Customer> findAllCustomers() {
		return customerDao.findAll();
	}


	public Customer updateCustomer(Customer customer) {
		return customerDao.save(customer);
	}



	public boolean deleteCustomer(int id) {
		if(customerDao.existsById(id)) {
			customerDao.deleteById(id);
			return true;
		}
		return false;
	}



	public Customer findCustomerByName(String name) {
		
		return customerDao.findCustomerByName(name);
	}




	public void addAddress(Address address) {
		addressDao.save(address);
		
	}


}
