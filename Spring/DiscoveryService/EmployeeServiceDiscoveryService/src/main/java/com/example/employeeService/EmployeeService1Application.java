package com.example.employeeService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmployeeService1Application {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeService1Application.class, args);
	}

}
