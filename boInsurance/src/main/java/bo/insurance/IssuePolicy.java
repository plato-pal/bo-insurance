package bo.insurance;

import java.math.BigDecimal;
import java.util.Random;

public class IssuePolicy {

	private String productCode;
	private String customerName;
	private String customerEmail;

	public IssuePolicy(String productCode, String customerName, String customerEmail) {
		this.productCode = productCode;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
	}
	
	public Policy doIssue() {
		Policy policy = new Policy();
		policy.setCustomerEmail(customerEmail);
		policy.setCustomerName(customerName);
		policy.setProductCode(productCode);
		policy.setTotalPremium(calcTotalPremium());
		policy.setNumber(genPolicyNumber());
		
		return policy;
	}

	private String genPolicyNumber() {
		Random random = new Random();
		int min = 10000;
		int max = 99999;
		return ((Integer) (random.nextInt(max - min) + min)).toString();
	}

	private BigDecimal calcTotalPremium() {
		Random random = new Random();
		double min = 50;
		double max = 500;
		double premium = min + (max - min) * random.nextDouble();
		return BigDecimal.valueOf(premium).setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}
	
}
