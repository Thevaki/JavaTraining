package com.thevaki.training.salesmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.thevaki.training.salesmanager.model.Employee;
import com.thevaki.training.salesmanager.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService{
	
	//@Autowired
	EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl() {
		System.out.println("default constructor executed");
	}

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		System.out.println("overload constructor executed");
		this.employeeRepository = employeeRepository;
	}

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	@Autowired
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		System.out.println("Setter executed");
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.getAllEmployees();
		
	}
	
}
