package bo.insurance;

import java.io.Serializable;
import java.math.BigDecimal;

public class IssuePolicyResponse implements Serializable {

	private static final long serialVersionUID = -8466122317249717971L;

	private String policyNumber;
	private BigDecimal policyCost;
	
	public IssuePolicyResponse() {}

	public IssuePolicyResponse(String policyNumber, BigDecimal policyCost) {
		this.policyNumber = policyNumber;
		this.policyCost = policyCost;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public BigDecimal getPolicyCost() {
		return policyCost;
	}

	public void setPolicyCost(BigDecimal policyCost) {
		this.policyCost = policyCost;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IssuePolicyResponse [policyNumber=");
		builder.append(policyNumber);
		builder.append(", policyCost=");
		builder.append(policyCost);
		builder.append("]");
		return builder.toString();
	}
}
