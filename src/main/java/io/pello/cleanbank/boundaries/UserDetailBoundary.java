package io.pello.cleanbank.boundaries;

import io.pello.cleanbank.entity.User;

public interface UserDetailBoundary {
	public User find (String userName);
}
