package com.binary_winters.employees_testing.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	@Column(name="job_code")
	private String jobCode;
	
	private Double salary;
	
	private Double plus;

	public Employee() {
		super();
	}

	public Employee(String name, String jobCode, Double salary, Double plus) {
		super();
		this.name = name;
		this.jobCode = jobCode;
		this.salary = salary;
		this.plus = plus;
	}

}
