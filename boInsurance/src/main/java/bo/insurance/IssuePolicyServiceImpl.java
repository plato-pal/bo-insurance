package bo.insurance;

import java.math.BigDecimal;

public class IssuePolicyServiceImpl implements IssuePolicyService {

	@Override
	public IssuePolicyResponse issuePolicy(IssuePolicyRequest issuePolicyRequest) {
		return new IssuePolicyResponse(1, new BigDecimal(2));
	}
}
