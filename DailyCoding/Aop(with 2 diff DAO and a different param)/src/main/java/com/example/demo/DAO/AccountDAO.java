package com.example.demo.DAO;

import com.example.demo.Account;

public interface AccountDAO {
	
	void addAccount();
	
	void addAccount(Account account);
	
	boolean addAccount(Account account, boolean vipFlag);
}	

