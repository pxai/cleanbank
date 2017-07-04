package io.pello.cleanbank.usecase;

import javax.inject.Inject;

import io.pello.cleanbank.entity.Account;
import io.pello.cleanbank.entity.gateway.AccountEntityGateway;

public class DepositMoney {
	private AccountEntityGateway accountEntityGateway;
	
	public Float deposit (Account account, Float money) {
		account.deposit(money);
		accountEntityGateway.update(account);
		return account.getBalance();
	}

	@Inject
	public void setAccountEntityGateway(AccountEntityGateway accountEntityGateway) {
		this.accountEntityGateway = accountEntityGateway;
	}
}
