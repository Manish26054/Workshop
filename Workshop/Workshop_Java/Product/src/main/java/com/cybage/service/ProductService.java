package com.cybage.service;

import java.util.List;

import com.cybage.dao.ProductDao;
import com.cybage.model.Product;

public interface ProductService extends ProductDao {
	
	Product getProductById(int productId);
	void addProduct(Product product);
	List<Product> getAllProduct();
	int deleteProduct(int productId);
}
