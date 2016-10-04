package model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="customer", 
uniqueConstraints={ @UniqueConstraint(columnNames={"customerID"}),@UniqueConstraint(columnNames={"email"})})
@Proxy(lazy=false)
public class Customer {
	@Id
	private int customerID;
	@Column(name="customerName", length=25, nullable=true)
	private String customerName;
	@Column(name="customerAddress", length=25, nullable=true)
	private String customerAddress;
	@Column(name="customerPhone")
	private String customerPhone;
	@Column(name="email")
	private String email;
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="customerID")
    private Set<ManageOrder> order;
	
    public Customer()
    {
    	
    }
	

	public Customer(int customerID, String customerName,
			String customerAddress, String customerPhone, String email) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerPhone = customerPhone;
		this.email = email;

	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}


	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}


	public void setOrder(Set<ManageOrder> order) {
		this.order = order;
	}


	public void setEmail(String email) {
		this.email = email;
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

	public Set<ManageOrder> getOrder() {
		return order;
	}
	
	public String getEmail() {
		return email;
	}
	
	
	

}