package com.cybage.workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.workshop.entity.Address;
import com.cybage.workshop.entity.Customer;
import com.cybage.workshop.exception.CustomerNotFoundException;
import com.cybage.workshop.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/allCustomers")
	public ResponseEntity<?> allCustomers(){
		List<Customer> customerList = customerService.findAllCustomers();
	return ResponseEntity.ok(customerList);
	}
	
	@GetMapping("/getByName/{name}")
	public ResponseEntity<?> getByName(@PathVariable String name){
		Customer customer = customerService.findCustomerByName(name);
	return ResponseEntity.ok(customer);
	}
	
	@PostMapping("/addCustomer")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
		customerService.save(customer);
		return new ResponseEntity<>("Customer added!!!",HttpStatus.OK);
	}
	
	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<?> updateCustomer(@PathVariable int id,@RequestBody Customer customer) throws CustomerNotFoundException{
		customer.setCustomerId(id);
		Customer updatedCustomer = customerService.updateCustomer(customer);
		if(updatedCustomer==null)
			throw new CustomerNotFoundException("Customer cannot be updated!!!");
		return new ResponseEntity<>("Updated Customer Data!!!",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) throws CustomerNotFoundException{
		boolean success=customerService.deleteCustomer(id);
		if(success==false)
			throw new CustomerNotFoundException("Cannot delete,Customer Not found !!!");
		return ResponseEntity.ok(success);
	}
	
	@PostMapping("/addAddress")
	public ResponseEntity<?> addAddress(@RequestBody Address address) {
		customerService.addAddress(address);
		return new ResponseEntity<>("Address added succesfully!!!",HttpStatus.OK);
	}
}
