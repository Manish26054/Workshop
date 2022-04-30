package com.cybage.airline.controller;


import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cybage.airline.entity.Complain;
import com.cybage.airline.model.LoginCredentials;
import com.cybage.airline.entity.User;
import com.cybage.airline.service.ComplainServiceImpl;
import com.cybage.airline.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class UserController {
	static Logger log= LogManager.getLogger(UserController.class);
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ComplainServiceImpl service;
	
	@PostMapping("/login")//Consuming Login api using rest template
	public ResponseEntity<?> userLogin(@RequestBody LoginCredentials credentials){
		//String url="http://localhost:9004/authenticate";
		String url="http://localhost:9001/login";
		log.info("Customer entered credentials=>"+credentials);
		return restTemplate.postForEntity(url,credentials,Object.class);
		
	}
	
	@PostMapping("/register")//Consuming Register api using rest template
	public ResponseEntity<?> userRegistration(@Valid @RequestBody User registrationForm){
		String url="http://localhost:9001/register";
		log.info("Registration form data => "+registrationForm);
		return restTemplate.postForEntity(url,registrationForm,Object.class);
	}
	
	
	@GetMapping("/getAllUsers")//Fetching user list
	public ResponseEntity<?> getAllUsers()
	{
		List<User>list=userService.findAll();
		return new ResponseEntity<>(list,HttpStatus.OK);
	
	}
	
	
	@PatchMapping("/updateUser/{id}")//updating particular user data
	public ResponseEntity<?> updateUser(@PathVariable int id,@RequestBody User user) {
		user.setUserId(id);
		User updateUser = userService.update(user);
		return  ResponseEntity.ok(updateUser);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		boolean success=userService.deleteUser(id);
		return ResponseEntity.ok(success);	
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id)
	{
        User user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	
	}
	
	@GetMapping("/getByEmail/{email}")
	public ResponseEntity<?> getUserByEmail(@PathVariable String email)
	{
        User user = userService.findByEmail(email);
		return ResponseEntity.ok(user);
	
	}
	
	
	/* ********************[User  Complain Contoller]************************** */
	
	//get all complaints
	@GetMapping("/getAllComplaints")
	public ResponseEntity<?> getAllComplaints()
	{
		
		List<Complain> li = service.findAll();
		return new ResponseEntity<>(li, HttpStatus.OK);
		
	}
	
	@GetMapping("/getComplainById/{id}")//getById/{id}
	public ResponseEntity<?> getComplainById(@PathVariable int id)
	{
		Complain comp = service.getComplainById(id);
		return ResponseEntity.ok(comp);
		
	}
	
	@PostMapping("/addNewComplain")
	public ResponseEntity<?> addNewComplain(@RequestBody Complain comp)
	{
		service.save(comp);
		return new ResponseEntity<>("Complain added successfully", HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteComplainById/{id}")
	public ResponseEntity<?> deleteComplainById(@PathVariable int id)
	{
		boolean comp = service.deleteComplain(id);
		return ResponseEntity.ok(comp);
		
	}
	
	@PutMapping("/updateComplain/{id}")
	public ResponseEntity<?> updateComplain(@PathVariable int id,@RequestBody Complain comp) {
		comp.setComplainId(id);
		Complain updateComplain = service.update(comp);
		
		return new ResponseEntity<>("Updated Complain Data!!!",HttpStatus.OK);
	}
	
	
	
	@PatchMapping("/updateStatus/{id}")   //update status
	
	public ResponseEntity<?>updateStatus(@PathVariable int id,@RequestBody Complain comp)
	{
		comp.setComplainId(id);
		Complain updateComplain = service.update(comp);
		return new ResponseEntity<>("Updated Complain Status....",HttpStatus.OK);
	}
	
	
	@GetMapping("/getComplainByStatus/{complainStatus}")//getById/{id}
	public ResponseEntity<?> getComplainByStatus(@PathVariable String complainStatus)
	{
		Complain comp = service.getComplainByStatus(complainStatus);
		return ResponseEntity.ok(comp);
		
	}
	
		
	
}
