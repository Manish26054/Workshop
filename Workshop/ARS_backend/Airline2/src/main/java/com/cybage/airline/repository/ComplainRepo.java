package com.cybage.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cybage.airline.entity.Complain;

@Repository
public interface ComplainRepo extends JpaRepository<Complain,Integer> {

	

	Complain findComplainByComplainStatus(String complainStatus);

}
