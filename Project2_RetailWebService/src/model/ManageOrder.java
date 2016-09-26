package model;

public class ManageOrder {
	
	private int orderID;
	private Customer customer;
	private String orderStatus;
	private String orderDate;
	private String orderQuantity;
	private double totalPrice;
	private Product product;
	
	public ManageOrder(int orderID, Customer customer, String orderStatus, String orderDate, String orderQuantity,
			double totalPrice, Product product) {
		super();
		this.orderID = orderID;
		this.customer = customer;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.orderQuantity = orderQuantity;
		this.totalPrice = totalPrice;
		this.product = product;
	}

	public int getOrderID() {
		return orderID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public String getOrderQuantity() {
		return orderQuantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public Product getProduct() {
		return product;
	}
	
	
	

}
