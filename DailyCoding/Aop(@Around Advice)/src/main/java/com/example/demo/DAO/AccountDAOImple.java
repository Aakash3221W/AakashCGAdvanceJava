package com.example.demo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.Account;

@Repository
public class AccountDAOImple implements AccountDAO {
	
	private String name;
	private String serviceCode;

	@Override
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}

	@Override
	public boolean doWork() {
		 System.out.println(getClass() + ": doing work");
		return false;
	}

	@Override
	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
		
	}

	@Override
	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
		
	}

	@Override
	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	@Override
	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
		
	}

	@Override
    public List<Account> findAccounts() {

        List<Account> myAccounts = new ArrayList<>();

        // create sample accounts
        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Madhu", "Platinum");
        Account temp3 = new Account("Luca", "Gold");

        // add them to our accounts list
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }

	@Override
	public List<Account> findAccounts(boolean tripWire) {
		
		if (tripWire) {
			throw new RuntimeException("Simulated Exception!");
		}
		
		return findAccounts();
	}



}
