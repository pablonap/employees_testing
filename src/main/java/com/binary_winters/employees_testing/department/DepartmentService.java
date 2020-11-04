package com.binary_winters.employees_testing.department;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		
		int highestSale = this.findHighestSale(departments);
		
		Set<Department> departmentsWithHighestSale = new HashSet<>();
		
		for (Department tempDepartment : departments) {
			if (tempDepartment.getSales() == highestSale) {
				departmentsWithHighestSale.add(tempDepartment);
			}
		}

		if (departmentsWithHighestSale.size() > 0) {
			this.assignPlus(departmentsWithHighestSale);
		}
		
	}
	
	private int findHighestSale(List<Department> departments) {

		int maxSales = 0;

		for (Department tempDepartment : departments) {
			if (tempDepartment.getSales() > maxSales ) {
				maxSales = tempDepartment.getSales();
			}
		}
		
		return maxSales;
	}

	private void assignPlus(Set<Department> departmentsWithHighestSale) {
		
		departmentsWithHighestSale.forEach(department -> department.getEmployees().stream().forEach(employee -> {
			if (employee.getJobCode().equalsIgnoreCase(JobCode.MNG.toString()) 
					|| employee.getSalary() >= TOP_SALARY ) {
				employee.setPlus(MIN_PLUS);
			} else {
				employee.setPlus(MAX_PLUS);
			}
			
			employeeRepository.save(employee);
		}));
		
	}
	
}