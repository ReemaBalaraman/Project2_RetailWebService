package com;

import model.Product;
import service.Functionalities;



public class Main {
	
	public static void main(String []args){
		
	Functionalities functions = new Functionalities();
	Product product = functions.serachProduct(1);
	System.out.print("Product search result :" + " " 
	+"Product Description - "+product.getProductDescription()+" "+"unit Price - "+  product.getUnitPrice());
	}
		

}
