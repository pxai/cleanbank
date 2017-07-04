package io.pello.cleanbank.boundaries;

import io.pello.cleanbank.entity.Account;

public interface DepositMoneyBoundary {
	public Float deposit (Account account, Float money);
}
