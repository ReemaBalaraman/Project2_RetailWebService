package com.service.customer;


import java.util.Set;

import javax.jws.WebService;

import com.service.representation.customer.CustomerRepresentation;
import com.service.representation.customer.CustomerRequest;

@WebService
public interface CustomerService {
	   
	public Set<CustomerRepresentation> getCustomer();
	public CustomerRepresentation getCustomer(String employeeId);
	public String addCustomer(CustomerRequest employeeRequest);
   
    //public Response updateEmployee(EmployeeRequest employeeRequest);
    //public Response deleteEmployee(String employeeId);
	
	

}
