package com.example.demo.DAOImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.DAO.EmployeeDAO;
import com.example.demo.Entity.Employee;
import com.example.demo.Exceptions.EmployeeNotFoundException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
public class EmployeeDAOImple implements EmployeeDAO {
	
	EntityManager entityManager;
	
	@Autowired
	EmployeeDAOImple(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> getAllEmployees(){
		TypedQuery<Employee> theQuery = entityManager.createQuery("Select e from Employee e",Employee.class);
		return theQuery.getResultList();
	}
	
	@Override
	public Employee getEmployeeById(int id) {
		Employee temp = entityManager.find(Employee.class, id);
		if(temp == null) {
			throw new EmployeeNotFoundException("Employee with id: " + id + " not found");
		}
		return temp;
	}
	
	
	@Override
	public void saveEmployee(Employee employee) {
		entityManager.persist(employee);
	}
	
	@Override
	public void deleteEmployeeById(int id) {
		Employee temp = entityManager.find(Employee.class, id);
		if(temp == null) {
			throw new EmployeeNotFoundException("Employee with id: " + id + " not found");
		}
		entityManager.remove(temp);
	}
	
	@Override
	public void updateEmployee(Employee employee) {
		entityManager.merge(employee);
	}
	
	
	

}
