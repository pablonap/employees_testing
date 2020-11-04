package com.binary_winters.employees_testing.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("/departments/{id}")
	public Department getDepartment(@PathVariable Long id) {
		return departmentService.getDepartmentById(id);
	}

}