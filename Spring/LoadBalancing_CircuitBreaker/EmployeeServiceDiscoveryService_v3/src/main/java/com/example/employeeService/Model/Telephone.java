package com.example.employeeService.Model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Entity
@Data
public class Telephone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String telephoneNumber;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn
	@JsonIgnore
	Employee employee;

}
