package com.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.Exception.ResourceNotFoundException;
import com.emp.model.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	IEmployeeRepository employeeRepository;

	
	//Method to save employee
	@Override
	public Integer saveEmployee(Employee employee) {
		
		Employee savedEmployee = employeeRepository.save(employee);
		
		return savedEmployee.getId();
	}


	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}


	@Override
	public Optional<Employee> getEmployeeById(Integer id) {
		
		
		
		return employeeRepository.findById(id);
	}


	@Override
	public void deleteEmployee(Integer id) {
		
		employeeRepository.deleteById(id);
		
	}


	@Override
	public void deleteAllEmployee() {
		employeeRepository.deleteAll();
		
	}


	@Override
	public Employee updateEmployee(Employee employee, Integer id) {
		
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee","id",id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		employeeRepository.save(existingEmployee);
		
		
		return existingEmployee;
	}
	
	
	
	

}
