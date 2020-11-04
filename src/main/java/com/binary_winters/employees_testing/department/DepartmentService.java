package com.binary_winters.employees_testing.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
	
	DepartmentRepository repository;
	
	@Autowired
	public DepartmentService(DepartmentRepository repository) {
		super();
		this.repository = repository;
	}

	public Department getDepartmentById(long id) {
		return repository.findById(id).get();
	}
	
}
