package com.example.employeeService.controller;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeService.Model.Employee;

@RestController
@RequestMapping("/Service")
@XmlRootElement
public class EmployeeController {
	@RequestMapping("/displayEmployees")
	public 	List<Employee> displayEmployees() {
		return Employee.getAllEmployees();
	}
}
