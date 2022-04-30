package com.cybage.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.airline.entity.UserDetail;

@Repository
public interface UserRepository extends JpaRepository<UserDetail, Integer>{
	UserDetail findByEmail(String email);
}
