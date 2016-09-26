package model;

public class Customer {
	
	private int customerID;
	private String customerAddress;
	private String customerPhone;
	private ManageOrder order;
	
	public Customer(int customerID, String customerAddress, String customerPhone, ManageOrder order) {
		super();
		this.customerID = customerID;
		this.customerAddress = customerAddress;
		this.customerPhone = customerPhone;
		this.order = order;
	}

	public int getCustomerID() {
		return customerID;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public ManageOrder getOrder() {
		return order;
	}
	
	
	
	

}
