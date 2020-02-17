package com.example.employeeService.hystrix;

import com.example.employeeService.Model.Allocation;
import com.example.employeeService.Model.Employee;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AllocationCommand extends HystrixCommand<Allocation[]> {

    private Employee employee;
    private HttpHeaders httpHeaders;
    private RestTemplate restTemplate;

    protected Allocation[] run(){
        HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<Allocation[]> result = restTemplate.exchange("http://allocation/Allocation/findAllocationByEmpId/" + employee.getId(), HttpMethod.GET, httpEntity, Allocation[].class);
        return result.getBody();
    }

    public  AllocationCommand(Employee employee, HttpHeaders httpHeaders, RestTemplate restTemplate){
        super(HystrixCommandGroupKey.Factory.asKey("default"));
        this.employee=employee;
        this.httpHeaders=httpHeaders;
        this.restTemplate=restTemplate;
    }

    @Override
    protected Allocation[] getFallback() {
        return new Allocation[0];
    }
}
