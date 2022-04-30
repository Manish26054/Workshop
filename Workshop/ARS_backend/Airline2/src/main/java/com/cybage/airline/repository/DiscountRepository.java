package com.cybage.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.airline.entity.Discount;



@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer> {

}
