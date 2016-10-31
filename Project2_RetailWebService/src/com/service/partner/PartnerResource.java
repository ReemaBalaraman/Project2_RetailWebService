package com.service.partner;

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


import com.service.representation.partner.PartnerRepresentation;
import com.service.representation.partner.PartnerRequest;
import com.service.workflow.partner.PartnerActivity;

@Path("/customerservice/")
public class PartnerResource implements PartnerService {

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/partner")
	//@Cacheable(cc="public, maxAge=3600") example for caching
	public Set<PartnerRepresentation> getPartner() {
		System.out.println("GET METHOD Request for all customers .............");
		PartnerActivity partActivity = new PartnerActivity();
		return partActivity.getPartner();	
	}
	
 @GET
	@Produces({"application/xml" , "application/json"})
	@Path("/partner/{partnerId}")
	public PartnerRepresentation getPartner(@PathParam("partnerId") String id) {
		System.out.println("GET METHOD Request from Client with partnerId String ............." + id);
		PartnerActivity partActivity = new PartnerActivity();
		return partActivity.getPartner(id);
	} 
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/partner")
	public PartnerRepresentation addPartner(PartnerRequest  partnerRequest) {
		//System.out.println("POST METHOD Request from Client with ............." + employeeRequest.getFirstName() + "  " + employeeRequest.getLastName());
		PartnerActivity partActivity = new PartnerActivity();
		return partActivity.addPartner(partnerRequest.getPartnerName(),partnerRequest.getpartnerType(),partnerRequest.getProduct());
	}
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/partner/{partnerId}")
	public Response deletePartner(@PathParam("partnerId") String id) {
		System.out.println("Delete METHOD Request from Client with partnerId String ............." + id);
		PartnerActivity partActivity = new PartnerActivity();
		String res = partActivity.deletPartner(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	@Override
	public PartnerRepresentation getPartner(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}