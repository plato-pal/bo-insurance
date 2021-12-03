package bo.insurance;

import java.math.BigDecimal;

public class Policy {
	
	private String productCode;
	private String customerName;
	private String customerEmail;
	private String number;
	private BigDecimal totalPremium;
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public BigDecimal getTotalPremium() {
		return totalPremium;
	}
	public void setTotalPremium(BigDecimal totalPremium) {
		this.totalPremium = totalPremium;
	}

}
