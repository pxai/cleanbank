package io.pello.cleanbank;

import java.util.Scanner;

import javax.inject.Inject;

import io.pello.cleanbank.boundaries.LoginBoundary;
import io.pello.cleanbank.boundaries.SeeDepositBoundary;

public class ConsoleUI {
	private LoginBoundary loginBoundary;
	private SeeDepositBoundary seeDepositBoundary;
	
	private Scanner reader;
	private String option;

	public ConsoleUI() {
		reader = new Scanner(System.in);
		option = "";
	}

	public void startApp() {
		validateUser();
		appLoop();
	}

	private void validateUser() {
		System.out.println("Please enter your account name");
		String account = reader.nextLine();
		System.out.println("Please enter your password");
		String password = reader.nextLine();

	}

	private void appLoop() {
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
		default:
				break;
		}
		
	}
	
	private void seeAvailableDeposit() {
		// TODO Auto-generated method stub
		
	}

	@Inject
	public void setLoginBoundary(LoginBoundary loginBoundary) {
		this.loginBoundary = loginBoundary;
	}
	
	@Inject
	public void setSeeDepositBoundary(SeeDepositBoundary seeDepositBoundary) {
		this.seeDepositBoundary = seeDepositBoundary;
	}

}
