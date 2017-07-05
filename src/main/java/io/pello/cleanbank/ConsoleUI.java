package io.pello.cleanbank;

import java.util.Scanner;

import javax.inject.Inject;

import io.pello.cleanbank.boundaries.DepositMoneyBoundary;
import io.pello.cleanbank.boundaries.LoginBoundary;
import io.pello.cleanbank.boundaries.UserDetailBoundary;
import io.pello.cleanbank.boundaries.WithdrawMoneyBoundary;
import io.pello.cleanbank.entity.Account;
import io.pello.cleanbank.entity.User;

public class ConsoleUI {
	private LoginBoundary loginBoundary;
	private UserDetailBoundary userDetailBoundary;
	private DepositMoneyBoundary depositMoneyBoundary;
	private WithdrawMoneyBoundary withdrawMoneyBoundary;

	private Scanner reader;
	private String option;

	private User user;

	public ConsoleUI() {
		reader = new Scanner(System.in);
		option = "";
	}

	public void startApp() {
		do {
			if (loginCorrect()) {
				System.out.println("Login correct!");
				appLoop();
			} else {
				System.err.println("Login incorrect!");
			}
		} while (true);
	}

	private boolean loginCorrect() {
		user = new User("", "", "", null);
		System.out.println("Please enter your login name");
		user.setLogin(reader.nextLine());
		System.out.println("Please enter your password");
		user.setPassword(reader.nextLine());

		return loginBoundary.login(user.getLogin(), user.getPassword());
	}

	private void loginIncorretMessage() {
		System.out.println("Login incorrect for user: " + user.getLogin());
	}

	private void getUserDetail() {
		user = userDetailBoundary.find(user.getLogin());
	}

	private void appLoop() {
		getUserDetail();
		System.out.println(user.getAccount().getAccountNo());
		do {
			showMenu();
			option = readOption();
			processOption();
		} while (!option.equals("4"));
	}

	private void showMenu() {
		System.out.println("Choose operation: ");
		System.out.println("1. See available deposit");
		System.out.println("2. Deposit money");
		System.out.println("3. Withdraw money");
		System.out.println("4. Exit");
		System.out.print("Your choice");
	}

	private String readOption() {
		return reader.nextLine();
	}

	private void processOption() {
		switch (option) {
		case "1":
			seeAvailableDeposit();
			break;
		case "2":
			depositMoney();
			break;
		case "3":
			withdrawMoney();
			break;
		default:
			break;
		}

	}

	private void depositMoney() {
		Float money = askAmount("Please enter amount for deposit");
		depositMoneyBoundary.deposit(user.getAccount(), money);
	}

	private void withdrawMoney() {
		Float money = askAmount("Please enter amount for withdrawal");
		withdrawMoneyBoundary.withdraw(user.getAccount(), money);
	}

	private Float askAmount(String message) {
		System.out.println(message);
		return Float.parseFloat(reader.nextLine());
	}

	private void seeAvailableDeposit() {
		user = userDetailBoundary.find(user.getLogin());
		System.out.println("Total deposit: " + user.getAccount().getBalance());
	}

	@Inject
	public void setLoginBoundary(LoginBoundary loginBoundary) {
		this.loginBoundary = loginBoundary;
	}

	@Inject
	public void setUserDetailBoundary(UserDetailBoundary userDetailBoundary) {
		this.userDetailBoundary = userDetailBoundary;
	}

	@Inject
	public void setDepositMoneyBoundary(DepositMoneyBoundary depositMoneyBoundary) {
		this.depositMoneyBoundary = depositMoneyBoundary;
	}

	@Inject
	public void setWithdrawMoneyBoundary(WithdrawMoneyBoundary withdrawMoneyBoundary) {
		this.withdrawMoneyBoundary = withdrawMoneyBoundary;
	}
}
