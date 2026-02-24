package com.example.demo.DAO;

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



}
