package com.emp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.Employee;
import com.emp.service.IEmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	IEmployeeService employeeService;

	@RequestMapping("/hello")
	public String hello() {
		return "Hello World";

	}

	@PostMapping("/employee")
	Integer createEmployee(@RequestBody Employee employee) {

		Integer id = employeeService.saveEmployee(employee);
		System.out.println(id);
		return id;

	}

	@GetMapping("/allemployees")
	public List<Employee> getEmployee() {
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/getEmployees/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable Integer id)
	{
		
		Optional<Employee> employee = employeeService.getEmployeeById(id);
		return employee;
		
	}
	

}
