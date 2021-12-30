package bo.insurance;

import java.math.BigDecimal;

public class IssuePolicyServiceImpl implements IssuePolicyService {

	@Override
	public IssuePolicyResponse issuePolicy(IssuePolicyRequest issuePolicyRequest) {
		
		IssuePolicy issuePolicy = new IssuePolicy(issuePolicyRequest.getProduct(), 
				issuePolicyRequest.getName(), issuePolicyRequest.getEmail());
		Policy policy = issuePolicy.doIssue();
		
		return new IssuePolicyResponse(policy.getNumber(), policy.getTotalPremium());
	}
}
