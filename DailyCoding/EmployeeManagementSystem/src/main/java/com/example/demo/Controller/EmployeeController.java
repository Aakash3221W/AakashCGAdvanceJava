package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entity.Employee;
import com.example.demo.Exceptions.CannotUpdateEmployeeIdException;
import com.example.demo.Sevices.EmployeeService;

import tools.jackson.databind.json.JsonMapper;


@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private EmployeeService employeeService;
	private JsonMapper jsonMapper;
	
	
	@Autowired
	public EmployeeController(EmployeeService employeeService, JsonMapper jsonMapper) {
		this.employeeService = employeeService;
		this.jsonMapper = jsonMapper;
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}
	
	@PostMapping("/employees")
	public void saveEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
	}
	
	@PatchMapping("/employees/{id}")
	public void updateEmployee(@RequestBody Map<String,Object> patchPayLoad, @PathVariable int id) {
		
		Employee employee = employeeService.getEmployeeById(id);
		if(patchPayLoad.containsKey("id")) {
			throw  new CannotUpdateEmployeeIdException("Cannot update employee id");
		}
		
		Employee updatedEmployee = jsonMapper.updateValue(employee, patchPayLoad);
		
		employeeService.updateEmployee(updatedEmployee);
		
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployeeById(@PathVariable int id) {
		employeeService.deleteEmployeeById(id);
	}

}
