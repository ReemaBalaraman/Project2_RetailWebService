package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.PaymentDetails;
import model.Product;



public class Main {
	
	public static void main(String []args){
		
	Functionalities functions = new Functionalities();

	// 1. Product Search Function call
	Product product = functions.serachProduct(1);
	System.out.println("Product search result :" + " " 
	+"Product Description - "+product.getProductDescription()+" "+"unit Price - "+  product.getUnitPrice());
	
	// 2. Payment Detail Validation
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
