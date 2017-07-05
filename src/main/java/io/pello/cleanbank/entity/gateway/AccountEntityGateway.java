package io.pello.cleanbank.entity.gateway;

import io.pello.cleanbank.entity.Account;

public interface AccountEntityGateway {
	public Account find (Integer customerId);
	public int update (Account account);
}
