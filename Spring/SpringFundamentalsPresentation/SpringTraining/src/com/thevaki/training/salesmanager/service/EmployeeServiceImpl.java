package com.thevaki.training.salesmanager.service;

import java.util.List;

import com.thevaki.training.salesmanager.model.Employee;
import com.thevaki.training.salesmanager.repository.EmployeeRepository;
import com.thevaki.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeRepository employeeRepository = new HibernateEmployeeRepositoryImpl();

	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}

}
