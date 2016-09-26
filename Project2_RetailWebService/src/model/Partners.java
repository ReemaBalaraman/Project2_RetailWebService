package model;

public class Partners {
	
	private int partnerID;
	private String partnerType;
	private String partnerName;
	private Product product;
	
	public Partners(int partnerID, String partnerType, String partnerName, Product product) {
		super();
		this.partnerID = partnerID;
		this.partnerType = partnerType;
		this.partnerName = partnerName;
		this.product = product;
	}

	public int getPartnerID() {
		return partnerID;
	}

	public String getPartnerType() {
		return partnerType;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public Product getProduct() {
		return product;
	}
	
	

}
