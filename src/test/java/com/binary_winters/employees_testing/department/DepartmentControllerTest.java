package com.binary_winters.employees_testing.department;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.assertThat;
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

		ResponseEntity<Object> response = testRestTemplate.getForEntity(API_DEPARTMENTS + "/assign-plus", Object.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	 
}