package com.binary_winters.employees_testing.department;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DepartmentControllerTest {
	
	private static final String API_DEPARTMENTS = "/api/departments";

	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	DepartmentService departmentService;

	@Before
	public void cleanup() {
		departmentRepository.deleteAll();
	}
	
	@Test
	public void getDepartment_whenAssignPlusIsInvoked_receiveOk() {

		ResponseEntity<Object> response = testRestTemplate.getForEntity(API_DEPARTMENTS, Object.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	public void putDepartment_whenThereAreThreeDepartmentsAndTwoWithHiguestSales_dbIsUpdatedWithPlus() {
		
		List<Department> departments = TestUtilDepartment.createDepartmentsWithEmployees(150, 390, 390);

		departments.stream().forEach(department -> departmentRepository.save(department));

		testRestTemplate.put(API_DEPARTMENTS + "/assign-plus", null);
		
		List<Department> dbDepartments = departmentRepository.findAll();
		
		Department firstDepartmentFoundWithHighestSaleRate = dbDepartments.stream()
				.filter(department -> department.getSales() == 390)
				.findFirst()
				.get();
		
		assertThat(firstDepartmentFoundWithHighestSaleRate.getEmployees().get(0).getPlus()).isGreaterThan(0);
	}

}