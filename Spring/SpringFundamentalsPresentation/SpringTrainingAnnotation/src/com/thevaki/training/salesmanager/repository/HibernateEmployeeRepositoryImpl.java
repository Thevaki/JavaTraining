package com.thevaki.training.salesmanager.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

//import org.springframework.stereotype.Repository;

import com.thevaki.training.salesmanager.model.Employee;

@Repository("employeeRepository")
public class HibernateEmployeeRepositoryImpl implements EmployeeRepository {

	public List<Employee> getAllEmployees(){
		List<Employee> employees = new ArrayList<>();
		
		Employee employee = new Employee();
		employee.setEmployeeName("Thevaki");
		employee.setEmployeeLocation("Colombo");
		employees.add(employee);
		return employees;
			
	}
}
