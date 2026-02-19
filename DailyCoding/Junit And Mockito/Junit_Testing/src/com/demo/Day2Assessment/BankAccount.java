package com.demo.Day2Assessment;

public class BankAccount {
	double balance;
	BankAccount(double balance) {
		this.balance = balance;
	}
	public double deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Deposit amount must be positive");
		}
		balance += amount;
		return balance;
	}
	
	public double withdraw(double amount) throws InsufficientBalanceException,IllegalArgumentException {
		if (amount < 0) {
			throw new IllegalArgumentException("Withdrawal amount must be positive");
		}
		if (amount > balance) {
			throw new InsufficientBalanceException("Insufficient balance for withdrawal");
		}
		balance -= amount;
		return balance;
	}
	
}
