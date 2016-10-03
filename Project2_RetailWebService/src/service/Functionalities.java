package service;

import java.util.Calendar;
import java.util.Date;

import dao.DBconnection;

import model.PaymentDetails;
import model.Product;

public class Functionalities {

	public Product serachProduct(int productID)
	{
		// Searching Product from DB based on ProductID
		DBconnection connect = new DBconnection();
		Product product = connect.searchProduct(productID);
		return product;

	}

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
}
