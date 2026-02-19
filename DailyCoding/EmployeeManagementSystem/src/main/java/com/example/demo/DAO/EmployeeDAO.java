package com.example.demo.DAO;

import java.util.List;

import com.example.demo.Entity.Employee;

public interface EmployeeDAO {

	List<Employee> getAllEmployees();

	void saveEmployee(Employee employee);

	void deleteEmployeeById(int id);

	void updateEmployee(Employee employee);

	Employee getEmployeeById(int id);

}
