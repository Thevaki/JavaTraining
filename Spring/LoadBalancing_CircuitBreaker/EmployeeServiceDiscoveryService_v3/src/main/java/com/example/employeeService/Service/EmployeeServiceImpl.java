package com.example.employeeService.Service;

import com.example.employeeService.Model.*;
import com.example.employeeService.Repository.EmployeeRepository;

import com.example.employeeService.hystrix.AllocationCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    //@Autowired
    HttpHeaders httpHeaders;

    //@Autowired
    RestTemplate restTemplate;

    /*@Bean
    @LoadBalanced
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }*/

    @Override
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Integer id){
        Optional<Employee> employee = employeeRepository.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        }
        return null;
    }

    public List<Employee> fetchAllEmployee(){
        return  employeeRepository.findAll();
    }

   /* public List<Allocation> fetchAllAllocations(){

        final String uri = "http://localhost:8080/Allocation/fetchAllAllocations";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Allocation[]> result = restTemplate.getForEntity(uri, Allocation[].class);

        Allocation[] resultBody = result.getBody();
        List<Allocation> allocations = new ArrayList<>();

        for (Allocation allocation : resultBody) {
            allocation.setEmployee(this.findEmployeeById(allocation.getEmpId()));
            allocations.add(allocation);
        }
        return allocations;
    }*/

    public Employee fetchAllocation(Integer id){
        Employee employee = this.findEmployeeById(id);
        AllocationCommand allocationCommand = new AllocationCommand(employee,httpHeaders,restTemplate);
        employee.setAllocations(Arrays.asList(allocationCommand.execute()));
        return employee;
    }


}
