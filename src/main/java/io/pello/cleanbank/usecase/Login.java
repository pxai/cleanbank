package io.pello.cleanbank.usecase;

import javax.inject.Inject;

import io.pello.cleanbank.boundaries.LoginBoundary;
import io.pello.cleanbank.entity.gateway.UserEntityGateway;

public class Login implements LoginBoundary {
	private UserEntityGateway userEntityGateway;
	
	public boolean login (String userName, String password) {
		return userEntityGateway.checkUser(userName, password);
	}
	
	@Inject
	public void setUserEntityGateway (UserEntityGateway userEntityGateway) {
		this.userEntityGateway = userEntityGateway;
	}
}
