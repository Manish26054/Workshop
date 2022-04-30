package com.cybage.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.airline.entity.Discount;
import com.cybage.airline.repository.DiscountRepository;



@Service
public class DiscountService {

	@Autowired
	DiscountRepository discountRespository;
	

public void addDiscount (Discount discount) {
	discountRespository.save(discount);
}

public List<Discount> getDiscount() {
	System.out.println("abcdefghijkol");
	return discountRespository.findAll();
}

public Discount getDiscountById(int id) {
	return discountRespository.findById(id).orElse(null);
}

public void deleteDiscount(int id) {
	discountRespository.deleteById(id);
}

public void updateDiscount(Discount discount) {
	discountRespository.save(discount);
}
}
