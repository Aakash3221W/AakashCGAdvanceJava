package com.example.demo.DAO;

import org.springframework.stereotype.Repository;

import com.example.demo.Account;

@Repository
public class MembershipDAOImple implements MembershipDAO {

	@Override
	public void addMembership() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");
		
	}
	
	@Override
	public void addMembership(Account account) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT WITH AN ACCOUNT PARAMETER");
		
	}

}
