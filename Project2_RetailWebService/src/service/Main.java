package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import model.PaymentDetails;
import model.Product;



public class Main {
	Functionalities functions = new Functionalities();
	public static void main(String []args){
		Functionalities functions1 = new Functionalities();
		Main main = new Main();
		//main.productSearch();
		//main.paymentDetailsCheck();
		Map<Product, Integer> productEligible = new HashMap<>();
		functions1.orderPlacement(productEligible,"",0.0);
		
		
	}
		
	

	// 1. Product Search Function call
	private void productSearch(){
	Product product = functions.serachProduct(1);
	System.out.println("Product search result :" + " " 
	+"Product Description - "+product.getProductDescription()+" "+"unit Price - "+  product.getUnitPrice());
	}
	
	// 2. Payment Detail Validation
	private void paymentDetailsCheck()
	{
	SimpleDateFormat dateformat = new SimpleDateFormat("MM/yyyy");
	Date date1 = null;
	try
	{
	 date1 = dateformat.parse("07/1989");
	}
	catch (ParseException e) {
		
        e.printStackTrace();
    }

	PaymentDetails pd = new PaymentDetails(1234567812345678L,889,"Reema",date1);	
	functions.paymentDetailsCheck(pd, 20.05);
	
	}
}
