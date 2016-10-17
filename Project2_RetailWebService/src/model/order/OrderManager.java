package model.order;

import java.util.Date;
import java.util.Map;

import dao.CustomerDAO;
import dao.ManageOrderDAO;
import model.customer.Customer;
import model.order.Order;
import model.product.Product;

public class OrderManager {
	
	
	
	public void orderPlacement(Map<Product, Integer> productEligible,String email,double amount)
	{
		Order mo = new Order();
		ManageOrderDAO moDAO = new ManageOrderDAO();
		CustomerDAO custDAO = new CustomerDAO();
		email = "test@gmail.com";
		amount= 20.05;
		Product prod = new Product(1,"Phone",700,200);
		productEligible.put(prod, 3);
		Customer customer = custDAO.fetchCustomer(email);
		mo.setOrderID(0);
		mo.setCustomer(customer);
		mo.setTotalPrice(amount);
		mo.setOrderDate(new Date());
		mo.setOrderStatus("Processing");
		moDAO.placeOrder(mo, productEligible);
		
	}

}
