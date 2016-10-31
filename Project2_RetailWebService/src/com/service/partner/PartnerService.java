package com.service.partner;

import java.util.Set;

import javax.jws.WebService;
import com.service.representation.partner.PartnerRepresentation;
import com.service.representation.partner.PartnerRequest;

@WebService
public interface PartnerService {
	   
	public Set<PartnerRepresentation> getPartner();
	public PartnerRepresentation getPartner(int partnerId);
	public PartnerRepresentation addPartner(PartnerRequest employeeRequest);
   
    //public Response updateEmployee(EmployeeRequest employeeRequest);
    //public Response deleteEmployee(String employeeId);
	
	

}
