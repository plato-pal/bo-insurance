package bo.insurance;


import org.apache.commons.lang3.StringUtils;

import bo.insurance.messaging.CustomerMessage;
import bo.insurance.messaging.Producer;

public class IssuePolicyServiceImpl implements IssuePolicyService {

	@Override
	public IssuePolicyResponse issuePolicy(IssuePolicyRequest issuePolicyRequest) {
		
		IssuePolicy issuePolicy = new IssuePolicy(issuePolicyRequest.getProduct(), 
				issuePolicyRequest.getName(), issuePolicyRequest.getEmail());
		
		Policy policy = issuePolicy.doIssue();

		if(policy.getNumber()!=null && policy.getTotalPremium()!=null && StringUtils.isNotEmpty(policy.getCustomerEmail())){
			CustomerMessage customerMessage = new CustomerMessage(policy.getCustomerName(), policy.getNumber(), policy.getCustomerEmail());
			try {
				Producer.sendMessage(customerMessage);
			} catch (Exception e) {
				System.err.println("The message could not be sent to Customer: " + e.getMessage());
				return new IssuePolicyResponse();
			}
		}
		
		return new IssuePolicyResponse(policy.getNumber(), policy.getTotalPremium());
	}
}
