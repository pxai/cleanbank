package io.pello.cleanbank.entity.gateway;

import io.pello.cleanbank.entity.Account;

public interface AccountEntityGateway {
	public Account find (String accountId);
	public void update (Account account);
}
