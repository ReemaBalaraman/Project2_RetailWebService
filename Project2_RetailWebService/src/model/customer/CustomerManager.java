package model.customer;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


import dao.CustomerDAO;


public class CustomerManager {
	
	CustomerDAO custDAO = new CustomerDAO();
	
	/* Fetch All Customer */
	public Set<Customer> getAllCustomers()
	{
		Set<Customer> customers = new HashSet<Customer>();
		customers = custDAO.fetchAllCustomers();
		return customers;
	}
	
/* Fetch  Customer based on ID*/
	
	public Customer getCustomers(String id)
	{
		Customer customer = new Customer();
		//call DAO 
		customer = custDAO.fetchCustomer(id);
		return customer;
	}
	
	/* Adds/Registers Customer */
	public String addCustomer(String name, String email, CustomerPhone phone, CustomerAddress address){
		
		Customer customer = new Customer();
        customer.setCustomerName(name);
        customer.setCustomerAddress(address);
       
        customer.setEmail(email);
        customer.setCustomerPhone(phone);
        String status = custDAO.addCustomer(customer);
	
        return status;
		
	}

	/* Deletes Customer based on the id */	
public String deleteCustomer(String id) {
		
		//dao.deleteEmployee(id);
		//em.deleteEmployee(id);
		
		return "OK";
	}
}
