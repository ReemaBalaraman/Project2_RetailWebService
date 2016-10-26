package com.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import model.customer.Customer;
import model.customer.CustomerAddress;
import model.customer.CustomerManager;
import model.customer.CustomerPhone;

import com.service.representation.CustomerRepresentation;

/**
 * This class' responsibility is to manage the workflow of accessing/creating/updating/deleting resources
 * using the CustomerDOA object.  
 *
 */
public class CustomerActivity {

	//private static EmployeeDAO dao = new EmployeeDAO();
	private static CustomerManager cm = new CustomerManager();
	
	public Set<CustomerRepresentation> getCustomer() {
		
		Set<Customer> customers = new HashSet<Customer>();
		Set<CustomerRepresentation> custRepresentations = new HashSet<CustomerRepresentation>();

		customers = cm.getAllCustomers();
		
		Iterator<Customer> it = customers.iterator();
		while(it.hasNext()) {
			Customer cust = (Customer)it.next();
          CustomerRepresentation customerRepresentation = new CustomerRepresentation();
          customerRepresentation.setCustomerID(cust.getCustomerID());
          customerRepresentation.setCustomerName(cust.getCustomerName());
          customerRepresentation.setEmail(cust.getEmail());
          customerRepresentation.setCustomerAddress(cust.getCustomerAddress());
          customerRepresentation.setCustomerPhone(cust.getCustomerPhone());
          
          
          //now add this representation in the list
          custRepresentations.add(customerRepresentation);
        }
		return custRepresentations;
	}
	
	public CustomerRepresentation getCustomer(String id) {
		
		Customer cust = new Customer();
		cust = cm.getCustomers(id);
		
		CustomerRepresentation custRep = new CustomerRepresentation();

		custRep.setCustomerID(cust.getCustomerID());
		custRep.setCustomerName(cust.getCustomerName());
		custRep.setEmail(cust.getEmail());
		custRep.setCustomerAddress(cust.getCustomerAddress());
		custRep.setCustomerPhone(cust.getCustomerPhone());
		
		return custRep;
	}
	
	public CustomerRepresentation addCustomer(String name, String email, CustomerPhone phone, CustomerAddress address) {
		
		//Employee emp = dao.addEmployee(firstName, lastName);
		Customer cust = cm.addCustomer(name, email, phone, address);
		
		CustomerRepresentation custRep = new CustomerRepresentation();

		custRep.setCustomerID(cust.getCustomerID());
		custRep.setCustomerName(cust.getCustomerName());
		custRep.setEmail(cust.getEmail());
		custRep.setCustomerAddress(cust.getCustomerAddress());
		custRep.setCustomerPhone(cust.getCustomerPhone());
		
		return custRep;
	}
	
	public String deleteCustomer(String id) {
		
		//dao.deleteEmployee(id);
		//em.deleteEmployee(id);
		
		return "OK";
	}
	
}
