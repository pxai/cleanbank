package io.pello.cleanbank.usecase;

import javax.inject.Inject;

import io.pello.cleanbank.boundaries.SeeDepositBoundary;
import io.pello.cleanbank.entity.gateway.AccountEntityGateway;

public class SeeDeposit implements SeeDepositBoundary {
	private AccountEntityGateway accountEntityGateway;
	
	public double seeDeposit (String accountId) {
		return accountEntityGateway.find(accountId).getBalance();
	}

	@Inject
	public void setAccountEntityGateway(AccountEntityGateway accountEntityGateway) {
		this.accountEntityGateway = accountEntityGateway;
	}
}
