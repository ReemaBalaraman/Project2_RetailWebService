package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.service.representation.customer.CustomerRepresentation;
import com.service.workflow.customer.CustomerActivity;

import dao.ProductDAO;

import model.customer.CustomerAddress;
import model.customer.CustomerPhone;
import model.paymentdetails.PaymentDetails;
import model.paymentdetails.PaymentDetailsManger;
import model.product.Product;





public class Main {
	public static void main(String []args){
		Main main = new Main();
		main.productSearch();
		//main.paymentDetailsCheck();
		//main.addCustomer();
       //main.fetchCustomer();
		
		
	}
		
	

	// 1. Product Search Function call
	private void productSearch(){
		System.out.println("Product search start :" + " ");
	ProductDAO prodDAO = new ProductDAO();
	Product product = prodDAO.searchProduct("1");
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
	
	//add Customer
public void addCustomer(){
	CustomerActivity ca = new CustomerActivity();
	String name = "TestCust";
	String email = "test1@gmail.com";
	CustomerAddress address = new CustomerAddress("testArea","testCity","testState","60660");
	CustomerPhone phone = new CustomerPhone("1234567","7654321");
	System.out.println(ca.addCustomer(name, email, phone, address));
}
public void fetchCustomer()
{
	CustomerActivity ca = new CustomerActivity();
	//CustomerRepresentation cr = ca.getCustomer("test1@gmail.com");
	Set<CustomerRepresentation> setCR = ca.getCustomer();
	for(CustomerRepresentation cr : setCR)
	{
	System.out.println(cr.getCustomerID() + " "+ cr.getEmail())	;
	}
}

}
