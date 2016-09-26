package model;

public class Product {
	private int productID;
	private String productDescription;
	private double unitPrice;
	
	/*public Product(int productID, String productDescription, double unitPrice, Customer customer) {
		super();
		this.productID = productID;
		this.productDescription = productDescription;
		this.unitPrice = unitPrice;
	}*/
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}


	
	

}
