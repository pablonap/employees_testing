package com.binary_winters.employees_testing.department;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.binary_winters.employees_testing.employee.EmployeeRepository;

@RunWith(SpringRunner.class)
class DepartmentServiceTest {
	
	private static final String successfullMessage = "Plus message added successfully.";
	private static final String unsuccessfullMessage = "Plus message added unsuccessfully.";
	
	@Test
	public void assignPlusToEmployees_whenThereAreThreeDepartmentsAndTwoWithHiguestSales_returnSucessMessage() {
		
		DepartmentRepository departmentRepositoryMock = mock(DepartmentRepository.class);
		
		EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

		List<Department> departments = TestUtilDepartment.createDepartmentsWithEmployees(150, 390, 390);

		given(departmentRepositoryMock.findAll()).willReturn(departments);

		DepartmentService departmentService = new DepartmentService(departmentRepositoryMock, employeeRepository);

		ReflectionTestUtils.setField(departmentService, "successfullMessage", "Plus message added successfully.");
		ReflectionTestUtils.setField(departmentService, "unsuccessfullMessage", "Plus message added unsuccessfully.");
		
		String response = departmentService.assignPlusToEmployees();
		
		Assert.assertEquals(successfullMessage, response);
		 
	}

	@Test
	public void assignPlusToEmployees_whenThereAreThreeDepartmentsWithZeroSalesEach_returnUnsuccessfullMessage() {
		
		DepartmentRepository departmentRepositoryMock = mock(DepartmentRepository.class);
		
		List<Department> departments = TestUtilDepartment.createDepartmentsWithEmployees(0, 0, 0);

		given(departmentRepositoryMock.findAll()).willReturn(departments);

		DepartmentService departmentService = new DepartmentService(departmentRepositoryMock);

		ReflectionTestUtils.setField(departmentService, "successfullMessage", "Plus message added successfully.");
		ReflectionTestUtils.setField(departmentService, "unsuccessfullMessage", "Plus message added unsuccessfully.");
		
		String response = departmentService.assignPlusToEmployees();
		
		Assert.assertEquals(unsuccessfullMessage, response);
		 
	}

	@Test
	public void assignPlusToEmployees_whenThereAreThreeDepartmentsWithNoEmployees_returnUnsuccessfullMessage() {
		
		DepartmentRepository departmentRepositoryMock = mock(DepartmentRepository.class);
		
		List<Department> departments = TestUtilDepartment.createDepartmentsWithEmployees(0, 0, 0);
		
		departments.stream().forEach(department -> department.getEmployees().clear());

		given(departmentRepositoryMock.findAll()).willReturn(departments);

		DepartmentService departmentService = new DepartmentService(departmentRepositoryMock);

		ReflectionTestUtils.setField(departmentService, "successfullMessage", "Plus message added successfully.");
		ReflectionTestUtils.setField(departmentService, "unsuccessfullMessage", "Plus message added unsuccessfully.");
		
		String response = departmentService.assignPlusToEmployees();
		
		Assert.assertEquals(unsuccessfullMessage, response);
		 
	}

	@Test
	public void assignPlusToEmployees_whenDepartmentListIsNull_returnUnsuccessfullMessage() {
		
		DepartmentRepository departmentRepositoryMock = mock(DepartmentRepository.class);
		
		List<Department> departments = null;
		
		given(departmentRepositoryMock.findAll()).willReturn(departments);

		DepartmentService departmentService = new DepartmentService(departmentRepositoryMock);

		ReflectionTestUtils.setField(departmentService, "successfullMessage", "Plus message added successfully.");
		ReflectionTestUtils.setField(departmentService, "unsuccessfullMessage", "Plus message added unsuccessfully.");
		
		String response = departmentService.assignPlusToEmployees();
		
		Assert.assertEquals(unsuccessfullMessage, response);
		 
	}

	@Test
	public void assignPlusToEmployees_whenThereAreThreeDepartmentsAndTheThreeWithHiguestSales_returnSucessMessage() {
		
		DepartmentRepository departmentRepositoryMock = mock(DepartmentRepository.class);

		EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
		
		List<Department> departments = TestUtilDepartment.createDepartmentsWithEmployees(390, 390, 390);

		given(departmentRepositoryMock.findAll()).willReturn(departments);

		DepartmentService departmentService = new DepartmentService(departmentRepositoryMock, employeeRepository);

		ReflectionTestUtils.setField(departmentService, "successfullMessage", "Plus message added successfully.");
		ReflectionTestUtils.setField(departmentService, "unsuccessfullMessage", "Plus message added unsuccessfully.");
		
		String response = departmentService.assignPlusToEmployees();
		
		Assert.assertEquals(successfullMessage, response);
		 
	}


}
