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
	
	@RequestMapping(value="/testFetch")
	Employee TestFetch(){
		List<Telephone> telephones = new ArrayList<>();
		//List<Employee> employees = new ArrayList<>();
		List<Project> projects = new ArrayList<>();
		
		Address address = new Address();
		address.setId(1);
		address.setCity("Colombo");

		Project project = new Project();
		project.setId(1);
		project.setProjectName("ProjectName");
		//project.setEmployees(employees);
		projects.add(project);
		
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("ABC");
		employee.setAddress(address);
		employee.setTelephones(telephones);
		employee.setProjects(projects);
		//employees.add(employee);
		
		Telephone telephone = new Telephone();
		telephone.setId(1);
		telephone.setTelephoneNumber("45435345");
		telephone.setEmployee(employee);
		telephones.add(telephone);
		
		return employee;
	}
	
	@RequestMapping(value = "/save" , method = RequestMethod.POST)
	Employee saveEmployee(@RequestBody Employee employee){
		
		for(Telephone telephone: employee.getTelephones()) {
			telephone.setEmployee(employee);
		}
		
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
	public HttpEntity<String> getAllAllocations()
	{
		final String uri = "http://localhost:8080/Allocation/fetchAllAllocations";

		RestTemplate restTemplate = new RestTemplate();
		//String result = restTemplate.getForObject(uri, String.class);
		ResponseEntity<String> response
				= restTemplate.getForEntity(uri , String.class);
		//assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

		return response;
	}
	
}
