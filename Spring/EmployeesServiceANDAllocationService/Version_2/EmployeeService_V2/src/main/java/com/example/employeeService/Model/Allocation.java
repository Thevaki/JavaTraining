package com.example.employeeService.Model;

public class Allocation {
    private int Id;
    private String startDate;
    private String endDate;
    private String projectCode;

    private Integer empId;
    private Employee employee;

    public int getId() {
        return Id;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public Integer getEmpId() {
        return empId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
