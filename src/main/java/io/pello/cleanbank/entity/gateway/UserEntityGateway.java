package io.pello.cleanbank.entity.gateway;

import io.pello.cleanbank.entity.User;

public interface UserEntityGateway {
	public User login (String login, String password);
}
