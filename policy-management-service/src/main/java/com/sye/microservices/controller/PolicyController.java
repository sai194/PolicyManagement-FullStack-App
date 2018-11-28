package com.sye.microservices.controller;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sye.microservices.domain.Policy;
import com.sye.microservices.service.PolicyService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PolicyController implements CommandLineRunner {

	@Autowired
	PolicyService policyService;

	// GET /users/{username}/policies
	@GetMapping("/users/{username}/policies")
	public List<Policy> getAllPolicies(@PathVariable String username) {
		return policyService.findPoliciesByUserName(username);
	}

	// users/{username}/policies/1
	@GetMapping("/users/{username}/policies/{id}")
	public Policy getPolicy(@PathVariable String username, @PathVariable long id) {
		return policyService.findPolicy(id);
	}
	
	//PUT /users/{user_name}/todos/{todo_id}
		@PutMapping("/users/{username}/policies/{id}")
		public ResponseEntity<Policy> updatePolicy(
				@PathVariable String username,
				@PathVariable long id, @RequestBody Policy policy){
			System.out.println(policy.toString());
			Policy policyUpdated = policyService.savePolicy(policy);
			
			return new ResponseEntity<Policy>(policy, HttpStatus.OK);
		}
		
		@PostMapping("/users/{username}/policies")
		public ResponseEntity<Void> updatePolicy(
				@PathVariable String username, @RequestBody Policy policy){
			policy.setUsername(username);
			policy.setId(null);
			System.out.println(policy.toString());
			Policy createdPolicy = policyService.savePolicy(policy);
			 
			//Location
			//Get current resource url
			///{id}
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(createdPolicy.getId()).toUri();
			
			return ResponseEntity.created(uri).build();
		}

	// DELETE /users/{username}/policies/{id}
	@DeleteMapping("/users/{username}/policies/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {

		Policy policy = policyService.findPolicy(id);

		if (policy != null) {
			policyService.deletePolicy(id);
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Policy p1 = new Policy(null, "Policy 1", false, new Date(), 10000D, "admin");
		Policy p2 = new Policy(null, "Policy 2", false, new Date(), 20000D, "admin");
		Policy p3 = new Policy(null, "Policy 3", false, new Date(), 30000D, "admin");

		policyService.savePolicy(p1);
		policyService.savePolicy(p2);
		policyService.savePolicy(p3);

	}

}
