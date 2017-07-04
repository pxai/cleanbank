package io.pello.cleanbank.external.entityrepository;

import io.pello.cleanbank.entity.gateway.UserEntityGateway;

import javax.inject.Inject;

import io.pello.cleanbank.entity.Account;
import io.pello.cleanbank.entity.User;


public class UserEntityDAO implements UserEntityGateway {
	private DataSource dataSource;
	
	public boolean checkUser(String userName, String password) {
		return false;
	}

	public User find(String userName) {
		return null;
	}
	
	@Inject
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
