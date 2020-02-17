package com.example.employeeService.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

import javax.persistence.*;

@Entity
@Data
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
    private String projectName;
    
    @ManyToMany(mappedBy = "projects",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Employee> employees;
    
}
