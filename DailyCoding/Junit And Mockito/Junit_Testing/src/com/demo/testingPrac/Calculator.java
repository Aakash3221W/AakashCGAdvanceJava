package com.demo.testingPrac;

public class Calculator {
	public int add(int a, int b) {
		return a + b;
	}

	public int sub(int a, int b) {
		return a - b;
	}

	public int mul(int a, int b) {
		return a * b;
	}

	public int div(int a, int b) {
		if (b == 0) {
			throw new IllegalArgumentException("Divisor cannot be zero");
		}
		return a / b;
	}
}
