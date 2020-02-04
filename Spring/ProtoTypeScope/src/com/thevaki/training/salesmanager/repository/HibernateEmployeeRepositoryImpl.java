package com.thevaki.training.salesmanager.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.thevaki.training.salesmanager.model.Employee;

@Repository("CanUseAnyName")
public class HibernateEmployeeRepositoryImpl implements EmployeeRepository {

	@Value("${name}")
	private String employeeName;
	@Value("${city}")
	private String employeeCity;
	
	public List<Employee> getAllEmployees(){
		List<Employee> employees = new ArrayList<>();
		
		Employee employee = new Employee();
		employee.setEmployeeName(employeeName);
		employee.setEmployeeLocation("Colombo");
		employees.add(employee);
		return employees;
			
	}
}
