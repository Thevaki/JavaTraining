package com.example.employeeService.hystrix;

import com.example.employeeService.Model.Allocation;
import com.example.employeeService.Model.Employee;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public class AllocationCommand extends HystrixCommand<Allocation[]> {

    private Employee employee;
    private HttpHeaders httpHeaders;
    private RestTemplate restTemplate;

    @Override
    protected Allocation[] run() throws Exception {
        return new Allocation[0];
    }

    public  AllocationCommand(Employee employee, HttpHeaders httpHeaders, RestTemplate restTemplate){
        super(HystrixCommandGroupKey.Factory.asKey("default"));
        this.employee=employee;
        this.httpHeaders=httpHeaders;
        this.restTemplate=restTemplate;
    }

    protected Allocation[] getFallBack(){
        return new Allocation[1];
    }
}
