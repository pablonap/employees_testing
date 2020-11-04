package com.binary_winters.employees_testing.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binary_winters.employees_testing.employee.Employee;
import com.binary_winters.employees_testing.employee.EmployeeRepository;
import com.binary_winters.employees_testing.employee.JobCode;

@Service
public class DepartmentService {
	
	private static final Double TOP_SALARY = 150000.00;
	private static final Double MIN_PLUS = 1000.00;
	private static final Double MAX_PLUS = 2000.00;

	private DepartmentRepository departmentRepository;
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public DepartmentService(DepartmentRepository departmentRepository,
			EmployeeRepository employeeRepository) {
		super();
		this.departmentRepository = departmentRepository;
		this.employeeRepository = employeeRepository;
	}

	public Department getDepartmentById(long id) {
		return departmentRepository.findById(id).get();
	}

	public List<Department> getAllDepartment() {
		return departmentRepository.findAll();
	}
	
	public void assignPlusToEmployees() {
		List<Department> departments = this.getAllDepartment();
		
		Department departmentWithMoreSales = null;
		int maxSales = 0;
		
		for (Department tempDepartment : departments) {
			if (tempDepartment.getSales() > maxSales ) {
				departmentWithMoreSales = tempDepartment;
				maxSales = tempDepartment.getSales();
			}
		}
		
		if (departmentWithMoreSales != null) {
			this.assignPlus(departmentWithMoreSales);
		}
		
	}

	private void assignPlus(Department departmentWithMoreSales) {
		List<Employee> employees = departmentWithMoreSales.getEmployees();
		
		for (Employee tempEmployee : employees) {
			
			if (tempEmployee.getJobCode().equalsIgnoreCase(JobCode.MNG.toString()) 
					|| tempEmployee.getSalary() >= TOP_SALARY ) {
				tempEmployee.setSalary(tempEmployee.getSalary() + MIN_PLUS);
			} else {
				tempEmployee.setSalary(tempEmployee.getSalary() + MAX_PLUS);
			}
			
			employeeRepository.save(tempEmployee);
		}
		
	}
	
}