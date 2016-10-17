package model.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTPHONE")
public class CustomerPhone {

	@Id
	@GeneratedValue
	@Column(name = "PHONE_ID")
	private long phoneID;
	@Column(name = "PRIMARY_NUMBER", nullable = false, length=20)
	private String primaryNumber;
	@Column(name = "SECONDARY_NUMBER",length=20)
	private String secondaryNumber;


	public CustomerPhone() {
	}


	public CustomerPhone(String primaryNumber,
			String secondaryNumber) {
		super();
		this.primaryNumber = primaryNumber;
		this.secondaryNumber = secondaryNumber;
	}


	public String getPrimaryNumber() {
		return primaryNumber;
	}


	public void setPrimaryNumber(String primaryNumber) {
		this.primaryNumber = primaryNumber;
	}


	public String getSecondaryNumber() {
		return secondaryNumber;
	}


	public void setSecondaryNumber(String secondaryNumber) {
		this.secondaryNumber = secondaryNumber;
	}
	
	
}
