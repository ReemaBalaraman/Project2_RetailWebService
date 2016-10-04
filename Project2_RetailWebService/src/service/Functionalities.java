package service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dao.DAOimpl;

import model.Customer;
import model.ManageOrder;
import model.Partners;
import model.PaymentDetails;
import model.Product;

public class Functionalities {
	
/* Searches Product based on ProductID*/
	public Product serachProduct(int productID)
	{
		// Searching Product from DB based on ProductID
		DAOimpl connect = new DAOimpl();
		Product product = connect.searchProduct(productID);
		return product;

	}
	
	/* Adds Partner*/
	public Partners addPartner(){
		DAOimpl connect = new DAOimpl();
		 Partners partner = new Partners();
		    Scanner scanner = new Scanner(System.in);

		    System.out.print("Enter your name: ");
		    String partnerName = scanner.nextLine();
		    partner.setPartnerName(partnerName);
		    
		    System.out.print("Enter type of partnership: ");
		    String partnerType = scanner.nextLine();
		    partner.setPartnerType(partnerType);
		    
		 
		 connect.addPartner(partner);
		return partner;
		
	}
	
	/* Adds/Registers Customer */
	public Customer addCustomer(){
		DAOimpl connect = new DAOimpl();
		Customer customer = new Customer();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
      String  customerName = scanner.nextLine();
        customer.setCustomerName(customerName);
        
        System.out.print("Enter your address: ");
        String customerAddress = scanner.nextLine();
        customer.setCustomerAddress(customerAddress);
        
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        customer.setEmail(email);
        
        System.out.print("Enter your phone: ");
       String customerPhone = scanner.nextLine();
        customer.setCustomerPhone(customerPhone);
		connect.addCustomer(customer);
		return customer;
		
	}
	
	/* Validating Payment details */
	public void paymentDetailsCheck (PaymentDetails paymentDetails,double amountPaid )
	{
		//First validating  payment details
		long cardNumber = paymentDetails.getCardNumber();
		int cvv = paymentDetails.getCvvCode();
		boolean valid = false ;
		Date date = paymentDetails.getExpirationDate();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		if(String.valueOf(cardNumber).length()<17)
		{
			if(String.valueOf(cvv).length()<4)
			{
				if(month>=1 && month<=12)
				{
					if(year > Calendar.getInstance().get(Calendar.YEAR) )
					{
						valid = true;	
						System.out.println("Payment details valid.");
					}

				}
			}
			if(!valid)
			{
				System.out.println("Please provide valid Payment details.");
			}
		}

//Once Payment Validation is completed payement has to be made calling 3rd Party service

	}
	
      /* Adding Products to cart*/
	public void BuyProduct(String email,Map<Integer,Integer> productQuantity){
		Product product = new Product();
		 double totalPrice = 0.0;
		Map<Product, Integer> productEligible = new HashMap<Product, Integer>();
		
		//looping through product to check availability and calculate total price
          for(Map.Entry<Integer, Integer> entry : productQuantity.entrySet())
          {
        	product = serachProduct(entry.getKey());
        	int orderQuantity = entry.getValue();
		if(product.getAvailableQuantity() >= orderQuantity){
			//adding eligible products
			productEligible.put(product, orderQuantity);
			totalPrice = totalPrice + product.getUnitPrice() * orderQuantity;
		}else{
			System.out.println("The product "+" " + product.getProductDescription()+ " " +" is currently out of stock");
		}
          }
	        //Palce order
	        orderPlacement(productEligible,email,totalPrice);
	}
	
	/* Placing order : creating row in Manageorder  table */
	public void orderPlacement(Map<Product, Integer> productEligible,String email,double amount)
	{
		ManageOrder mo = new ManageOrder();
		DAOimpl connect = new DAOimpl();
		email = "test@gmail.com";
		amount= 20.05;
		Product prod = new Product(1,"Phone",700,200);
		productEligible.put(prod, 3);
		Customer customer = connect.fetchCustomer(email);
		mo.setOrderID(0);
		mo.setCustomer(customer);
		mo.setTotalPrice(amount);
		mo.setOrderDate(new Date());
		mo.setOrderStatus("Processing");
		connect.placeOrder(mo, productEligible);
		
	}
}
