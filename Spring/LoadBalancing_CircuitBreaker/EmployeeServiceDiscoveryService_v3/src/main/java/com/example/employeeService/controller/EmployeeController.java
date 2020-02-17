package com.example.employeeService.controller;

import com.example.employeeService.Model.*;
import com.example.employeeService.Service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/createEmployees" , method = RequestMethod.POST)
	public Employee save(@RequestBody Employee employee){
		return employeeService.save(employee);
	}

	@RequestMapping(value="/findEmployeeById/{id}",method = RequestMethod.POST)
	public Employee findEmployee(@PathVariable("id") Integer id){
		return employeeService.findById(id);
	}

	@RequestMapping(value="/fetchAllEmployees",method = RequestMethod.GET)
	public List<Employee> fetchAllEmployees(){
		return employeeService.fetchAllEmployee();
	}

	@RequestMapping("/fetchAllocation/{id}")
	public Employee fetchAllocation(@PathVariable Integer id) {

		return employeeService.fetchAllocation(id);
	}

}
