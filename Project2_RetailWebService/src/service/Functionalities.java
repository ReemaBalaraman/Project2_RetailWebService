package service;

import com.DBconnection;

import model.Product;

public class Functionalities {

	public Product serachProduct(int productID)
	{

		DBconnection connect = new DBconnection();
		Product product = connect.searchProduct(productID);
		return product;

	}
}
