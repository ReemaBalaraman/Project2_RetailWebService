package model.customer;

import java.util.Scanner;


import dao.CustomerDAO;


public class CustomerManager {
	
	/* Adds/Registers Customer */
	public void addCustomer(){
		CustomerDAO custDAO = new CustomerDAO();
		Customer customer = new Customer();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
      String  customerName = scanner.nextLine();
        customer.setCustomerName(customerName);
        
        System.out.print("Enter your address: ");
        System.out.print("Enter your street: ");
        String street = scanner.nextLine();
        String city = scanner.nextLine();
        String state = scanner.nextLine();
        String zipCode = scanner.nextLine();
        
        CustomerAddress custAdd = new CustomerAddress(street, city, state, zipCode);
        customer.setCustomerAddress(custAdd);
        
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        customer.setEmail(email);
        
        System.out.print("Enter your phone: ");
        System.out.print("Enter your Primary Number: ");
       String primaryPhone = scanner.nextLine();
       System.out.print("Enter your Secondary Number: ");
       String secondaryPhone = scanner.nextLine();
       CustomerPhone phone = new CustomerPhone(primaryPhone,secondaryPhone);
        customer.setCustomerPhone(phone);
        custDAO.addCustomer(customer);
		
		
	}

}
