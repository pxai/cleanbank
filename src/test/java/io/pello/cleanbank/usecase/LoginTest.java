package io.pello.cleanbank.usecase;

import static org.junit.Assert.*;

import org.junit.Test;

import io.pello.cleanbank.entity.User;

public class LoginTest {

	
	@Test
	public void testLoginWitNull () {
		Login userLogin = new Login();
		boolean actual = userLogin.login("","");
		
		assertFalse("Empty user return null",actual);
	}

	@Test
	public void testLoginWithSample () {
		Login userLogin = new Login();
		boolean actual = userLogin.login("test","test");
		
		assertFalse("Empty user return null",actual);
	}
}
