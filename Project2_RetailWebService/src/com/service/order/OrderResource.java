package com.service.order;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.CacheControl;

import com.service.representation.order.OrderRepresentation;
import com.service.representation.order.OrderRequest;
import com.service.workflow.order.OrderActivity;

@WebService(targetNamespace = "http://order.service.com/", endpointInterface = "com.service.order.OrderService", portName = "OrderResourcePort", serviceName = "OrderResourceService")
@Path("/orderservice/")
public class OrderResource implements OrderService {

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/order")
	//@Cacheable(cc="public, maxAge=3600") example for caching
	public Set<OrderRepresentation> getOrder() {
		System.out.println("GET METHOD Request for all orders .............");
		OrderActivity ordActivity = new OrderActivity();
		return ordActivity.getOrder();	
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/order/{orderId}")
	public OrderRepresentation getOrder(@PathParam("employeeId") String id) {
		System.out.println("GET METHOD Request from Client with orderID String ............." + id);
		OrderActivity ordActivity = new OrderActivity();
		return ordActivity.getOrder(id);
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/order")
	public String addOrder(OrderRequest  orderRequest) {
		//System.out.println("POST METHOD Request from Client with ............." + employeeRequest.getFirstName() + "  " + employeeRequest.getLastName());
		OrderActivity ordActivity = new OrderActivity();
		return ordActivity.addOrder(orderRequest.getOrderDate(),orderRequest.getTotalPrice(), orderRequest.getProductOrder(),orderRequest.getCustomerEmail());
	}
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/order/{orderId}")
	public Response deleteOrder(@PathParam("employeeId") String id) {
		System.out.println("Delete METHOD Request from Client with orderID String ............." + id);
		OrderActivity ordActivity = new OrderActivity();
		String res = ordActivity.deleteOrder(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	
	
}