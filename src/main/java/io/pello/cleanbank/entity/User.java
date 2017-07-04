package io.pello.cleanbank.entity;

public class User {
	private String login;
	private String password;
	private String name;
	private Account account;
	
	public User(String login, String password, String name, Account account) {
		this.login = login;
		this.password = password;
		this.name = name;
		this.account = account;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
