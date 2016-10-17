package model.product;

import java.util.HashMap;
import java.util.Map;

import dao.ProductDAO;
import model.product.Product;
import model.order.OrderManager;

public class ProductManager {
	
	OrderManager om = new OrderManager();
	
	public Product serachProduct(int productID)
	{
		// Searching Product from DB based on ProductID
		ProductDAO  prodDAO = new ProductDAO();
		Product product = prodDAO.searchProduct(productID);
		return product;

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
		        om.orderPlacement(productEligible,email,totalPrice);
		}

}
