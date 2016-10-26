package model.customer;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


import dao.CustomerDAO;


public class CustomerManager {
	
	/* Fetch All Customer */
	
	public Set<Customer> getAllCustomers()
	{
		Set<Customer> customers = new HashSet<Customer>();
		//call DAO here
		return customers;
	}
	
/* Fetch  Customer based on ID*/
	
	public Customer getCustomers(String id)
	{
		Customer customer = new Customer();
		//call DAO here
		return customer;
	}
	
	/* Adds/Registers Customer */
	public Customer addCustomer(String name, String email, CustomerPhone phone, CustomerAddress address){
		CustomerDAO custDAO = new CustomerDAO();
		Customer customer = new Customer();
        customer.setCustomerName(name);
        customer.setCustomerAddress(address);
       
        customer.setEmail(email);
        customer.setCustomerPhone(phone);
        custDAO.addCustomer(customer);
	
        return customer;
		
	}

	/* Deletes Customer based on the id */	
public String deleteCustomer(String id) {
		
		//dao.deleteEmployee(id);
		//em.deleteEmployee(id);
		
		return "OK";
	}
}
