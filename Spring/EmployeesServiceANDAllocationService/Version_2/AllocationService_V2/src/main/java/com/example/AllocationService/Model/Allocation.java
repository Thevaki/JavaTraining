package com.example.AllocationService.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Allocation {

    @Id
    @GeneratedValue
    private int id;
    private int empId;
    private String startDate;
    private String endDate;
    private String projectName;

    public int getId() {
        return id;
    }

    public int getEmpId() {
        return empId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
