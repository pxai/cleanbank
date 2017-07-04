package io.pello.cleanbank.usecase;

import javax.inject.Inject;
import io.pello.cleanbank.entity.gateway.AccountEntityGateway;

public class SeeDeposit {
	private AccountEntityGateway accountEntityGateway;
	
	public double seeDeposit (String accountId) {
		return accountEntityGateway.find(accountId).getBalance();
	}

	@Inject
	public void setAccountEntityGateway(AccountEntityGateway accountEntityGateway) {
		this.accountEntityGateway = accountEntityGateway;
	}
}
