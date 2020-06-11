package com.employee.portal;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.util.Assert;

import com.employee.portal.controller.GeneralController;

@SpringBootTest
class EmployeePortalApplicationTests {
	
	@Autowired
	GeneralController generalController;

	@Test
	@DirtiesContext
	void contextLoads() {
		Assert.notNull(generalController,"object not null");
	}

}
