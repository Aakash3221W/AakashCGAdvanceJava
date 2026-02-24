package com.example.demo.DAO;

import org.springframework.stereotype.Repository;

import com.example.demo.Account;

@Repository
public class AccountDAOImple implements AccountDAO {

	@Override
	public void addAccount() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	@Override
	public void addAccount(Account account) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT WITH AN ACCOUNT PARAMETER");
	}
	
	@Override
	public boolean addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT WITH AN ACCOUNT AND VIP FLAG PARAMETERS");
		return vipFlag;
	}

}
