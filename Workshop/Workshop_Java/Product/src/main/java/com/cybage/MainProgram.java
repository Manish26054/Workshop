package com.cybage;

import java.util.List;
import java.util.Scanner;
import com.cybage.dao.ProductDaoImpl;
import com.cybage.model.Product;

public class MainProgram {

	static Scanner sc = new Scanner(System.in);
	
	public static int menuList( ) {
		System.out.println("0.Exit");
		System.out.println("1.Add Product");
		System.out.println("2.Find Product By Id");
		System.out.println("3.Remove Product");
		System.out.println("4.Update Product");
		System.out.println("5.Display All");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	
	
	public static void main(String[] args) {
		ProductDaoImpl dao =new ProductDaoImpl();
		int[] productId = new int[1];
		int choice;
		
		while( ( choice = MainProgram.menuList( ) ) != 0 ) {
			switch( choice ) {
			
			case 1:
				System.out.println("Enter Product Details :");
				Product product=MainProgram.productDetails();
				dao.addProduct(product);
				break;
				
			case 2:
				MainProgram.acceptProductId(productId);
				Product productData = dao.getProductById(productId[0]);
				System.out.println(productData);
				break;
			case 3:
				MainProgram.acceptProductId(productId);
				int count=dao.deleteProduct(productId[0]);
				System.out.println("Product deleted==>"+count);
				break;
			case 4:
				MainProgram.acceptProductId(productId);
				System.out.print("Enter New Price : ");
				double price=sc.nextDouble();
				int countRecord = dao.updateProduct(productId[0], price);
				System.out.println("Product updated==>"+countRecord);
				break;
			case 5:
				List<Product> productList = dao.getAllProduct();
				productList.forEach(myProduct->System.out.println(myProduct));
				break;
			}
		}
	}




	private static void acceptProductId(int[] productId) {
		System.out.print("Enter Product Id : ");
		productId[0]=sc.nextInt();
	}


	private static Product productDetails() {
		Product product=new Product();
		sc.nextLine();
		System.out.print("Enter Product Name : ");
		product.setProductName(sc.nextLine());
	
		System.out.print("Enter Product Price : ");
		product.setProductPrice(sc.nextDouble());
		return product;
	}

}
