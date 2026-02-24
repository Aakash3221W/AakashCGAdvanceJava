package com.example.demo;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImple implements AccountDAO {

	@Override
	public void addAccount() {
		System.out.println("Adding an account in the database");
	}
	
	@Override
	public void addAccount(Account account) {
		System.out.println("Adding an account in the database with an Account parameter");
	}

}
