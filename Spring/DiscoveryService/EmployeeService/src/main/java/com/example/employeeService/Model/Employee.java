package com.example.employeeService.Model;

import lombok.Data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
}
