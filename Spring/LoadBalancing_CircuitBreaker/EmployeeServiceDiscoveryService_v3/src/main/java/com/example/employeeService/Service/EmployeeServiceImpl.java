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

    @Autowired
    HttpHeaders httpHeaders;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Employee save(Employee employee){
        for (Telephone telephone : employee.getTelephones()) {
            telephone.setEmployee(employee);
        }
        return employeeRepository.save(employee);
    }

    public Employee findById(Integer empId){
        Optional<Employee> employees = employeeRepository.findById(empId);
        if(employees.isPresent()) {
            return employees.get();
        }
        return new Employee();
    }

    public List<Employee> fetchAllEmployee(){
        return  employeeRepository.findAll();
    }

    public Employee fetchAllocation(Integer id){
        Employee employee = this.findById(id);
        AllocationCommand allocationCommand = new AllocationCommand(employee,httpHeaders,restTemplate);
        employee.setAllocations(Arrays.asList(allocationCommand.execute()));
        return employee;
    }


}
