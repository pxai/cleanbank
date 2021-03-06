package io.pello.cleanbank.usecase;

import javax.inject.Inject;

import io.pello.cleanbank.boundaries.WithdrawMoneyBoundary;
import io.pello.cleanbank.entity.Account;
import io.pello.cleanbank.entity.gateway.AccountEntityGateway;

public class WithdrawMoney implements WithdrawMoneyBoundary {
	private AccountEntityGateway accountEntityGateway;
	
	public Float withdraw (Account account, Float money) {
		account.withdraw(money);
		accountEntityGateway.update(account);
		return account.getBalance();
	}

	@Inject
	public void setAccountEntityGateway(AccountEntityGateway accountEntityGateway) {
		this.accountEntityGateway = accountEntityGateway;
	}
}
