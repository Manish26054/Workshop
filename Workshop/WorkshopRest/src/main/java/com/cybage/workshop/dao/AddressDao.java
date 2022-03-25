package com.cybage.workshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.workshop.entity.Address;

public interface AddressDao extends JpaRepository<Address, Integer>{

}
