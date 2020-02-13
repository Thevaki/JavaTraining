package com.example.AllocationService.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Allocation {

    @Id
    @GeneratedValue
    private int id;
    private String projectName;
    private String empName;
}
