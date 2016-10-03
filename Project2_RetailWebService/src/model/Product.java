package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="product", 
uniqueConstraints={ @UniqueConstraint(columnNames={"productID"})})
@Proxy(lazy=false)
public class Product {
	@Id
	private int productID;
	@Column(name="ProductDescription", length=25, nullable=true)
	private String productDescription;
	@Column(name="UnitPrice")
	private double unitPrice;

	public Product()
	{

	}
	public Product(int productID, String productDescription, double unitPrice) {
		super();
		this.productID = productID;
		this.productDescription = productDescription;
		this.unitPrice = unitPrice;
	}

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
