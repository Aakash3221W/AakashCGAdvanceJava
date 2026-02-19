package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer>{
	
	//No need to write any code here as JpaRepository provides all the necessary methods for CRUD operations on Employee entity.

}
