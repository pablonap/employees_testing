package com.binary_winters.employees_testing.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binary_winters.employees_testing.shared.GenericResponse;

@RestController
@RequestMapping("/api")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("/departments/{id}")
	public Department getDepartment(@PathVariable Long id) {
		return departmentService.getDepartmentById(id);
	}
	
	@GetMapping("/departments")
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartment();
	}
	
	@GetMapping("/departments/assign-plus")
	public GenericResponse assignPlus() {
		String plusMessage = departmentService.assignPlusToEmployees();

		return new GenericResponse(plusMessage);
	}


}