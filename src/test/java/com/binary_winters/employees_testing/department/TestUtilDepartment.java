package com.binary_winters.employees_testing.department;

import java.util.ArrayList;
import java.util.List;

import com.binary_winters.employees_testing.employee.Employee;

public class TestUtilDepartment {
	
	public static List<Department> createDepartmentsWithEmployees(Integer saleRate1, Integer saleRate2, Integer saleRate3) {

		List<Department> departments = new ArrayList<>();
		departments.add(new Department(1L, saleRate1));
		departments.add(new Department(2L, saleRate2));
		departments.add(new Department(3L, saleRate3));
		
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("john connor", "dev", Double.valueOf("120000"), Double.valueOf("0")));
		employees.add(new Employee("luis ramirez", "dev", Double.valueOf("125000"), Double.valueOf("0")));
		employees.add(new Employee("jose lopez", "mng", Double.valueOf("170000"), Double.valueOf("0")));
		employees.add(new Employee("tom lee", "mng", Double.valueOf("155000"), Double.valueOf("0")));
		employees.add(new Employee("ivan drago", "dev", Double.valueOf("120000"), Double.valueOf("0")));
		
		departments.get(1).getEmployees().add(employees.get(0));
		departments.get(1).getEmployees().add(employees.get(1));
		departments.get(1).getEmployees().add(employees.get(2));
		
		departments.get(2).getEmployees().add(employees.get(3));
		departments.get(2).getEmployees().add(employees.get(4));
		
		return departments;
		
	}

}
