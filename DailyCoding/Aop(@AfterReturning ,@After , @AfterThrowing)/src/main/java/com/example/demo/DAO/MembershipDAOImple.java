package com.example.demo.DAO;

import org.springframework.stereotype.Repository;

import com.example.demo.Account;

@Repository
public class MembershipDAOImple implements MembershipDAO {

	@Override
	public boolean addSillyMember() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");
		return true;
	}

	@Override
	public void goToSleep() {
		 System.out.println(getClass() + ": go to sleep");
		
	}

}
