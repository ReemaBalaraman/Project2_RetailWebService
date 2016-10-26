package com.service;


import java.util.Set;

import javax.jws.WebService;

import com.service.representation.CustomerRepresentation;
import com.service.representation.CustomerRequest;

@WebService
public interface CustomerService {
	   
	public Set<CustomerRepresentation> getCustomer();
	public CustomerRepresentation getCustomer(String employeeId);
	public CustomerRepresentation addCustomer(CustomerRequest employeeRequest);
   
    //public Response updateEmployee(EmployeeRequest employeeRequest);
    //public Response deleteEmployee(String employeeId);
	
	

}
