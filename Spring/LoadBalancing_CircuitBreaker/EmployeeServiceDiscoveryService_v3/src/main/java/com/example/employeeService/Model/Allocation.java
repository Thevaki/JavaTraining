package com.example.employeeService.Model;

import lombok.Data;

@Data
public class Allocation {
    private int Id;
    private String startDate;
    private String endDate;
    private String projectCode;

    private Integer empId;
    private Employee employee;
}
