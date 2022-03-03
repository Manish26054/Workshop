package com.cybage.service;

import java.util.List;

import com.cybage.dao.ProductDaoImpl;
import com.cybage.model.Product;


public class ProductServiceImpl implements ProductService{

	ProductDaoImpl dao =new ProductDaoImpl();
	

	public Product getProductById(int productId) {
	
		return dao.getProductById(productId);
	}

	public void addProduct(Product product) {
		dao.addProduct(product);
	}

	public List<Product> getAllProduct() {
		return dao.getAllProduct();
	}

	public int deleteProduct(int productId) {
		return dao.deleteProduct(productId);
	}
	
	public int updateProduct(int productId, double price) {
		return dao.updateProduct(productId, price);
	}



}
