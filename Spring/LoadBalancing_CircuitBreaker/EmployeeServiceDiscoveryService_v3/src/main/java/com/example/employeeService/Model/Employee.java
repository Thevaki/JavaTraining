package com.example.employeeService.Model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String city;

	@OneToOne(cascade = CascadeType.ALL)
	private Address Address;
	
	@OneToMany(mappedBy="employee",cascade = CascadeType.ALL)
	private List<Telephone> telephones;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="project_employee",
			   joinColumns= @JoinColumn (name="eid", referencedColumnName="id"),
			   inverseJoinColumns=@JoinColumn(name="pid",referencedColumnName="id"))
	private List<Project>projects;

	@Transient
	private List<Allocation> allocations = new ArrayList<>();

}
