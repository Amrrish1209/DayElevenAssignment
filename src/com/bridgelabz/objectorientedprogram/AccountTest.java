package com.bridgelabz.objectorientedprogram;

class Account {
	private double balance;

	public Account(double initialBalance) {
		balance = initialBalance;
	}

	public void credit(double amount) {
		balance += amount;
	}

	public void debit(double amount) {
		if (amount > balance) {
			System.out.println("Debit amount exceeded account balance.");
		} else {
			balance -= amount;
		}
	}

	public double getBalance() {
		return balance;
	}
}

public class AccountTest {

	public static void main(String[] args) {
		Account account = new Account(1000.0);

		System.out.println("Initial balance: " + account.getBalance());

		account.credit(500.0);
		System.out.println("After credit: " + account.getBalance());

		account.debit(300.0);
		System.out.println("After debit: " + account.getBalance());

		account.debit(1500.0);
		System.out.println("After debit: " + account.getBalance());
	}
}
