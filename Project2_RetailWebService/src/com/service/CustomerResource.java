package com.service;


import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.CacheControl;

import com.service.representation.CustomerRepresentation;
import com.service.representation.CustomerRequest;
import com.service.workflow.CustomerActivity;

@Path("/customerservice/")
public class CustomerResource implements CustomerService {

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/customer")
	//@Cacheable(cc="public, maxAge=3600") example for caching
	public Set<CustomerRepresentation> getCustomer() {
		System.out.println("GET METHOD Request for all customers .............");
		CustomerActivity custActivity = new CustomerActivity();
		return custActivity.getCustomer();	
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/employee/{employeeId}")
	public CustomerRepresentation getCustomer(@PathParam("employeeId") String id) {
		System.out.println("GET METHOD Request from Client with custRequest String ............." + id);
		CustomerActivity custActivity = new CustomerActivity();
		return custActivity.getCustomer(id);
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/employee")
	public CustomerRepresentation addCustomer(CustomerRequest  customerRequest) {
		//System.out.println("POST METHOD Request from Client with ............." + employeeRequest.getFirstName() + "  " + employeeRequest.getLastName());
		CustomerActivity custActivity = new CustomerActivity();
		return custActivity.addCustomer(customerRequest.getCustomerName(),customerRequest.getEmail(),customerRequest.getCustomerPhone(),customerRequest.getCustomerAddress());
	}
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/employee/{employeeId}")
	public Response deleteCustomer(@PathParam("employeeId") String id) {
		System.out.println("Delete METHOD Request from Client with employeeRequest String ............." + id);
		CustomerActivity custActivity = new CustomerActivity();
		String res = custActivity.deleteCustomer(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}
	
}