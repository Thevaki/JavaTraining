package com.thevaki.training.salesmanager.repository;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thevaki.training.salesmanager.model.Employee;
import com.thevaki.training.salesmanager.service.EmployeeService;
import com.thevaki.training.salesmanager.service.EmployeeServiceImpl;

public class Application {
	public static void main(String[] args) {
		/*EmployeeService employeeService = new EmployeeServiceImpl();
		
		List<Employee> employees = employeeService.getAllEmployees();
	
		for(Employee employee : employees) {
			System.out.println(employee.getEmployeeName() + " at " + employee.getEmployeeLocation());
		}*/
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		EmployeeService employeeService = applicationContext.getBean("employeeServe",EmployeeService.class);
		
		List<Employee> employees = employeeService.getAllEmployees();
		
		for(Employee employee : employees) {
			System.out.println(employee.getEmployeeName() + " at " +employee.getEmployeeLocation());
		}
	}
}
