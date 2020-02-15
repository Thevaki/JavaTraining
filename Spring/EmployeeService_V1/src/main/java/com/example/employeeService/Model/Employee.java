package com.example.employeeService.Model;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String name;
	private int marks;

	public Employee(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}

	public Employee() {
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public static List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();

		Employee employee = new Employee();
		employee.setName("Thevaki");
		employee.setMarks(55);
		employees.add(employee);
		employee.setName("Claire");
		employee.setMarks(70);
		employees.add(employee);
		employee.setName("David");
		employee.setMarks(40);
		employees.add(employee);

		return employees;
	}
}
