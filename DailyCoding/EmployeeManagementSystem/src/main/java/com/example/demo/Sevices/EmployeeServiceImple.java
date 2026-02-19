package com.example.demo.Sevices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.EmployeeDAO;
import com.example.demo.Entity.Employee;

import jakarta.transaction.Transactional;


@Service
public class EmployeeServiceImple implements EmployeeService {

	EmployeeDAO employeeDAO;
	@Autowired
	public EmployeeServiceImple(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Override
	@Transactional
	public void saveEmployee(com.example.demo.Entity.Employee employee) {
		employeeDAO.saveEmployee(employee);
		
	}

	@Override
	@Transactional
	public void deleteEmployeeById(int id) {
		employeeDAO.deleteEmployeeById(id);
		
	}

	@Override
	@Transactional
	public void updateEmployee(Employee employee) {
		employeeDAO.updateEmployee(employee);
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeDAO.getEmployeeById(id);
	}

}
