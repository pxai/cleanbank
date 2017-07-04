package io.pello.cleanbank.usecase;

import static org.junit.Assert.*;

import org.junit.Test;

import io.pello.cleanbank.entity.User;

public class LoginInteractorTest {

	
	@Test
	public void testLoginWitNull () {
		LoginInteractor loginInteractor = new LoginInteractor();
		User expected = new User("","","",null);
		User actual = loginInteractor.login(expected);
		assertNull("Empty user return null",actual);
	}

	@Test
	public void testLoginWithSample () {
		LoginInteractor loginInteractor = new LoginInteractor();
		User expected = new User("test","test","test",null);
		User actual = loginInteractor.login(expected);
		assertEquals("Empty user return null",expected, actual);
	}
}
