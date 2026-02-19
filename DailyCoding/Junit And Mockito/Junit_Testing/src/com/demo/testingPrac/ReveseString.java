package com.demo.testingPrac;

public class ReveseString {
	public String reverse(String str) {
		StringBuilder sb = new StringBuilder(str);
		return sb.reverse().toString();
	}
	
	public String plaindrome(String str) {
		StringBuilder sb = new StringBuilder(str);
		String reversed = sb.reverse().toString();
		return str.equals(reversed) ? "Palindrome" : "Not a Palindrome";
	}
	
	
}
