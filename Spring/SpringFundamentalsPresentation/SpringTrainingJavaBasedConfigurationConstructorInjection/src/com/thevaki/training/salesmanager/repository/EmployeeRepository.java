package com.thevaki.training.salesmanager.repository;

import java.util.List;

import com.thevaki.training.salesmanager.model.Employee;

public interface EmployeeRepository {

	List<Employee> getAllEmployees();

}