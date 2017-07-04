package io.pello.cleanbank.entity.gateway;

import io.pello.cleanbank.entity.User;

public interface UserEntityGateway {
	public boolean checkUser (String userName, String password);
	public User find (String userName);
}
