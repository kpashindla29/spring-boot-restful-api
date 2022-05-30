package com.ab.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="department_details")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int deptId;
	
	
	private String deptName;
	
	
	@OneToMany(mappedBy = "deptId")
	private List<Employee> employees;
	
	

}
