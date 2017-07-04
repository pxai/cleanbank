package io.pello.cleanbank.usecase;

import javax.inject.Inject;

import io.pello.cleanbank.boundaries.UserDetailBoundary;
import io.pello.cleanbank.entity.User;
import io.pello.cleanbank.entity.gateway.UserEntityGateway;

public class UserDetail implements UserDetailBoundary {
	private UserEntityGateway userEntityGateway;
	
	public User find (String userName) {
		return userEntityGateway.find(userName);
	}
	
	@Inject
	public void setUserEntityGateway (UserEntityGateway userEntityGateway) {
		this.userEntityGateway = userEntityGateway;
	}
}
