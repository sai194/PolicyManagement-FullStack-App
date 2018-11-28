package com.sye.microservices;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sye.microservices.domain.Policy;
import com.sye.microservices.domain.User;
import com.sye.microservices.service.PolicyService;
import com.sye.microservices.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PolicyManagementServiceApplicationTests {

	@Autowired
	PolicyService policyService;
	@Autowired
	UserService userService;

	@Test
	public void testAdmin() {

		User adminUser = userService.findUserByUserName("admin");
		Assert.assertEquals("admin", adminUser.getUserName());
	}
	
	@Test
	public void testUser() {

		User user = userService.findUserByUserName("user");
		Assert.assertEquals("user", user.getUserName());
	}

	@Test
	public void testPolicies() {
		List<Policy> policies = policyService.findPoliciesByUserName("admin");
		Assert.assertEquals(3, policies.size());
	}

}
