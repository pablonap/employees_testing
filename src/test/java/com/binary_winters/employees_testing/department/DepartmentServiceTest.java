package com.binary_winters.employees_testing.department;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(SpringRunner.class)
class DepartmentServiceTest {
	
	private static final String successfullMessage = "Plus message added successfully.";
	private static final String unsuccessfullMessage = "Plus message added unsuccessfully.";
	
	@Test
	public void assignPlusToEmployees_whenThereAreThreeDepartmentsAndTwoWithHiguestSales_returnSucessMessage() {
		
		DepartmentRepository departmentRepositoryMock = mock(DepartmentRepository.class);
		
		List<Department> departments = TestUtilDepartment.createDepartmentsWithEmployees(150, 390, 390);

		given(departmentRepositoryMock.findAll()).willReturn(departments);

		DepartmentService departmentService = new DepartmentService(departmentRepositoryMock);

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

}
