package com.binary_winters.employees_testing.department;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.binary_winters.employees_testing.employee.Employee;

import lombok.Data;

@Data
@Entity
@Table(name="department")
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Integer sales;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="department_id")
	private List<Employee> employees = new ArrayList<>();

	public Department() {
		super();
	}

	public Department(Long id, Integer sales) {
		super();
		this.id = id;
		this.sales = sales;
	}
	
}