package com.example.employeeService.Model;

import lombok.Data;

import java.util.List;

import javax.persistence.*;

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	Address Address;
	
	@OneToMany(mappedBy="employee",cascade = CascadeType.ALL)
	List<Telephone>telephones;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="project_employee",
			   joinColumns= @JoinColumn (name="eid", referencedColumnName="id"),
			   inverseJoinColumns=@JoinColumn(name="pid",referencedColumnName="id"))
	List<Project>projects;

	@Transient
	private List<Allocation> allocations;

	public void setAllocations(List<Allocation> asList) {
	}
}
