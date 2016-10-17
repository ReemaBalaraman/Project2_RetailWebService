package model.partner;

import java.util.Scanner;

import dao.PartnersDAO;


public class PartnerManager {
	
	
	public Partners addPartner(){
		PartnersDAO pDAO = new PartnersDAO();
		 Partners partner = new Partners();
		    Scanner scanner = new Scanner(System.in);

		    System.out.print("Enter your name: ");
		    String partnerName = scanner.nextLine();
		    partner.setPartnerName(partnerName);
		    
		    System.out.print("Enter type of partnership: ");
		    String partnerType = scanner.nextLine();
		    partner.setPartnerType(partnerType);
		    
		 
		    pDAO.addPartner(partner);
		return partner;
		
	}
	

}
