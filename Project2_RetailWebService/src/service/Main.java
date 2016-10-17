package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import dao.ProductDAO;

import model.paymentdetails.PaymentDetails;
import model.paymentdetails.PaymentDetailsManger;
import model.product.Product;





public class Main {
	public static void main(String []args){
		Main main = new Main();
		main.productSearch();
		main.paymentDetailsCheck();

		
		
	}
		
	

	// 1. Product Search Function call
	private void productSearch(){
	ProductDAO prodDAO = new ProductDAO();
	Product product = prodDAO.searchProduct(1);
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
	PaymentDetailsManger pdm = new PaymentDetailsManger();
	pdm.paymentDetailsCheck(pd, 20.05);
	
	}
}
