package com.example.employeeService.controller;

import com.example.employeeService.Model.Address;
import com.example.employeeService.Model.Employee;
import com.example.employeeService.Model.Project;
import com.example.employeeService.Model.Telephone;
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
@XmlRootElement
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/createEmployees" , method = RequestMethod.POST)
	public Employee save(@RequestBody Employee employee){
		return employeeService.save(employee);
	}
	
	@RequestMapping(value = "/save" , method = RequestMethod.POST)
	Employee saveEmployee(@RequestBody Employee employee){
		return employeeService.save(employee);
	}

	@RequestMapping(value="/findEmployees/{id}",method = RequestMethod.POST)
	public Employee findEmployee(@PathVariable("id") Integer id){
		return employeeService.findEmployee(id);
	}

	@RequestMapping(value="/fetchAllEmployees",method = RequestMethod.GET)
	public List<Employee> fetchAllEmployees(){
		return employeeService.fetchAllEmployee();
	}

	@RequestMapping(value="/fetchAllAllocationsEmployee",method = RequestMethod.GET)
	public String getAllAllocations()
	{
		final String uri = "http://localhost:8080/Allocation/fetchAllAllocations";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}
	
}
