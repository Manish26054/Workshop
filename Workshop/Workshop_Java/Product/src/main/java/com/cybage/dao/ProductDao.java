package com.cybage.dao;


import java.util.List;


import com.cybage.model.Product;



public interface ProductDao{
	Product getProductById(int productId);
	void addProduct(Product product);
	List<Product> getAllProduct();
	int deleteProduct(int productId);
	int updateProduct(int productId, double price);
}
