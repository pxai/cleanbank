package io.pello.cleanbank.boundaries;

import io.pello.cleanbank.entity.Account;

public interface WithdrawMoneyBoundary {
	public Float withdraw (Account account, Float money);
}

