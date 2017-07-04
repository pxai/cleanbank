package io.pello.cleanbank.external.entityrepository;

import io.pello.cleanbank.entity.gateway.AccountEntityGateway;

import javax.inject.Inject;

import io.pello.cleanbank.entity.Account;


public class AccountEntityDAO implements AccountEntityGateway {
	private DataSource dataSource;
	
	public Account find (String accountId) {
		return null;
	}
	
	public void update (Account account) {
		
	}

	@Inject
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
