package com.cybage.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.cybage.dbutils.DBUtil;
import com.cybage.model.Product;


public class ProductDaoImpl implements ProductDao{
	private Connection connection;
	private Statement statement;
	
	public ProductDaoImpl() {
		
		try {
			this.connection = DBUtil.getConnection();
			this.statement = this.connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Product getProductById(int productId) {
		String sql = "Select *from product where productId="+productId;
		
		try(ResultSet rs= statement.executeQuery(sql)){
			while(rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductPrice(rs.getDouble(3));
				
				return product;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addProduct(Product product) {
		String sql = "INSERT INTO product VALUES("+product.getProductId()+",'"+product.getProductName()+"',"+product.getProductPrice()+")";
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Product> getAllProduct() {
		
		String sql="Select * from product";
		List<Product> products = new ArrayList<>();
		
		try(ResultSet rs = statement.executeQuery(sql);){
			
			while (rs.next())
				products.add(new Product(rs.getInt(1), rs.getString(2),rs.getDouble(3)));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	public int deleteProduct(int productId) {
		
		String sql = "DELETE FROM product WHERE productid="+productId;
		
		try {
			return this.statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
		
	}

	public int updateProduct(int productId,double price) {
		String sql="update product set productprice="+price+"where productid="+productId;
		
		try {
			return this.statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}

}
