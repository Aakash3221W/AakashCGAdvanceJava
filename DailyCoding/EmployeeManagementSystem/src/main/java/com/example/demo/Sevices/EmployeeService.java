package com.example.demo.Sevices;

import java.util.List;

import com.example.demo.Entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	void saveEmployee(Employee employee);

	void deleteEmployeeById(int id);

	void updateEmployee(Employee employee);

	Employee getEmployeeById(int id);
}
