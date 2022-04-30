package com.cybage.airline.service;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cybage.airline.entity.UserDetail;
import com.cybage.airline.repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles=null;
		UserDetail user = userDao.findByEmail(username);
		
		if(user!=null) {
			if(user.getRole().equals("admin")) {
				roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
				return new User(user.getEmail(),user.getPassword(),roles);
			}
			else if(user.getRole().equals("customer")) {
				roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
				return new User(user.getEmail(), user.getPassword(),roles);
			}
		
		}else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return null;
	}
	
	public UserDetail save(@Valid UserDetail user) {
		UserDetail newUser = new UserDetail();
		user.setRole("customer");
		BeanUtils.copyProperties(user, newUser);
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userDao.save(newUser);
	}

	public UserDetail findByEmail(String userEmail) {
		return userDao.findByEmail(userEmail);
	}


}
