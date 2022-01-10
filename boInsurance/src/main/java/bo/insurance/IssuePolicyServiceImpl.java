package bo.insurance;


import org.apache.commons.lang3.StringUtils;

import bo.insurance.messaging.CustomerMessage;
import bo.insurance.messaging.PolicyMessagingService;

public class IssuePolicyServiceImpl implements IssuePolicyService {

	@Override
	public IssuePolicyResponse issuePolicy(IssuePolicyRequest issuePolicyRequest) {
		
		IssuePolicy issuePolicy = new IssuePolicy(issuePolicyRequest.getProduct(), 
				issuePolicyRequest.getName(), issuePolicyRequest.getEmail());
		
		Policy policy = issuePolicy.doIssue();

		sendToCustomerQueue(policy);
		sendToCollectionsQueue(policy);
		
		return new IssuePolicyResponse(policy.getNumber(), policy.getTotalPremium());
	}

	private void sendToCustomerQueue(Policy policy) {
		if(!StringUtils.isEmpty(policy.getNumber()) && !StringUtils.isEmpty(policy.getCustomerName()) && StringUtils.isNotEmpty(policy.getCustomerEmail())){
			CustomerMessage customerMessage = new CustomerMessage(policy.getCustomerName(), policy.getNumber(), policy.getCustomerEmail());
			try {
				PolicyMessagingService.sendMessage(customerMessage, CustomerMessage.CUSTOMER_QUEUE_NAME);
			} catch (Exception e) {
				System.err.println("The message could not be sent to Customer: " + e.getMessage());
			}
		}
	}
	
	private void sendToCollectionsQueue(Policy policy) {
		if(!StringUtils.isEmpty(policy.getNumber()) && null != policy.getTotalPremium()){
			CollectionsNewPolicyMessage collectionsNewPolicyMessage 
			= new CollectionsNewPolicyMessage(policy.getNumber(), policy.getTotalPremium());
			try {
				PolicyMessagingService.sendMessage(collectionsNewPolicyMessage, CollectionsNewPolicyMessage.COLLECTIONS_QUEUE);
			} catch (Exception e) {
				System.err.println("The message could not be sent to collections: " + e.getMessage());
			}
		}
	}
}
