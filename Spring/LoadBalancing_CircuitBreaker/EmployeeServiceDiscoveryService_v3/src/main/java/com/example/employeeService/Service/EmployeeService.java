package com.example.employeeService.Service;

import java.util.List;

import com.example.employeeService.Model.*;

public interface EmployeeService  {
    Employee save(Employee employee);

    Employee findEmployeeById(Integer id);

    List<Employee> fetchAllEmployee();

    //List<Allocation> fetchAllAllocations();

    Employee fetchAllocation(Integer id);
}
