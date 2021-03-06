package io.pello.cleanbank.entity;

public class Account {
	private String accountNo;
	private Float balance;
	
	public Account(String accountNo, Float balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Float getBalance() {
		return balance;
	}

	public void deposit (Float money) {
		balance = balance + money;
	}
	
	public void withdraw (Float money) {
		balance = balance - money;
	}
	
}
