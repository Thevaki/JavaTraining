package com.example.employeeService.Service;

import com.example.employeeService.Model.*;
import com.example.employeeService.Repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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

    /*@Value("${service.host}")
    private String allocationServiceHost;

    @Value("{service.allocation.findAll}")
    private String findAll;*/

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

    public List<Allocation> fetchAllAllocations(){

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

    }

}
