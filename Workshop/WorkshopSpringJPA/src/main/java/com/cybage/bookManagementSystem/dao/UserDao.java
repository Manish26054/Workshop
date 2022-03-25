package com.cybage.bookManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.bookManagementSystem.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	User findByEmail(String email);

}
