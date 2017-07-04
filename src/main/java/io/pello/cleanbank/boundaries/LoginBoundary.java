package io.pello.cleanbank.boundaries;

import io.pello.cleanbank.entity.User;

public interface LoginBoundary {
	public boolean login (String userName, String password);
}
