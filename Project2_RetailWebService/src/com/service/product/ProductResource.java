package com.service.product;

import java.util.Date;
import java.util.Map;
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

import com.service.representation.product.ProductRepresentation;
import com.service.representation.product.ProductRequest;
import com.service.workflow.product.ProductActivity;

@WebService(targetNamespace = "http://product.service.com/", endpointInterface = "com.service.product.ProductService", portName = "ProductResourcePort", serviceName = "ProductResourceService")
@Path("/productservice/")
public class ProductResource implements ProductService {

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/product")
	//@Cacheable(cc="public, maxAge=3600") example for caching
	public Set<ProductRepresentation> getProduct() {
		System.out.println("GET METHOD Request for all customers .............");
		ProductActivity proActivity = new ProductActivity();
		return proActivity.getProduct();	
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/product/{productId}")
	public ProductRepresentation getProduct(@PathParam("productId") String id) {
		System.out.println("GET METHOD Request from Client with productId String ............." + id);
		ProductActivity proActivity = new ProductActivity();
		return proActivity.getProduct(id);
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/product")
	public String addProduct(ProductRequest  productRequest) {
		//System.out.println("POST METHOD Request from Client with ............." + employeeRequest.getFirstName() + "  " + employeeRequest.getLastName());
		ProductActivity proActivity = new ProductActivity();
		return proActivity.addProduct(productRequest.getProductDescription(),productRequest.getUnitPrice(),productRequest.getAvailableQuantity());
	}
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/product/{productId}")
	public Response deleteProduct(@PathParam("productId") String id) {
		System.out.println("Delete METHOD Request from Client with productId String ............." + id);
		ProductActivity proActivity = new ProductActivity();
		String res = proActivity.deleteProduct(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/product/buy")
	public void buyProduct(String email,Date orderDate,Map<String,Integer> productQuantity)
	{
		ProductActivity proActivity = new ProductActivity();
		proActivity.buyProduct(email, orderDate, productQuantity);
	}
	
}