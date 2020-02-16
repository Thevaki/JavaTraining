package com.example.employeeService.Model;

import lombok.Data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@Data
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
    private String projectName;
    
    @ManyToMany(mappedBy = "projects")
    List<Employee> employees;
    
}
