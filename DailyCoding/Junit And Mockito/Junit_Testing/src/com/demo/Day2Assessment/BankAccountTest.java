package com.demo.Day2Assessment;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class BankAccountTest {
	@BeforeAll
	static void setup() {
		BankAccount account = new BankAccount(1000);
	}
	@ParameterizedTest
	@CsvSource({
		"500, 1500",
		"200, 1200",
	})
	void shouldDoSuccessfulDeposit(double amount, double expectedBalance) {
		BankAccount account = new BankAccount(1000);
		double newBalance = account.deposit(amount);
		assertEquals(expectedBalance, newBalance);
	}
	
	@ParameterizedTest
	@CsvSource({
		"500, 500",
		"200, 800",
	})
	void shouldDoSuccessfulWithdrawal(double amount, double expectedBalance) throws InsufficientBalanceException {
		BankAccount account = new BankAccount(1000);
		double newBalance = account.withdraw(amount);
		assertEquals(expectedBalance, newBalance);
	}
	
	@ParameterizedTest
	@CsvSource({
		"1500",
		"1200",
	})
	void shouldThrowInsufficientBalanceException(double amount) {
		BankAccount account = new BankAccount(1000);
		assertThrows(InsufficientBalanceException.class, () -> account.withdraw(amount));
	}
	
	@ParameterizedTest
	@CsvSource({
		"-500",
		"-200",
	})
	void shouldThrowIllegalArgumentExceptionForNegativeDeposit(double amount) {
		BankAccount account = new BankAccount(1000);
		assertThrows(IllegalArgumentException.class, () -> account.deposit(amount));
	}
	
	
}
