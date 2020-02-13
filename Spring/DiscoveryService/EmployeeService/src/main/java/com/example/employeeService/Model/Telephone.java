package com.example.employeeService.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Telephone {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String telephoneNumber;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	Employee employee;

}
