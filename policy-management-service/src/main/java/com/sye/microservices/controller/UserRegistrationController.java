package com.sye.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sye.microservices.domain.User;
import com.sye.microservices.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserRegistrationController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/userRegistration")
	public ResponseEntity<User> updatePolicy(@RequestBody User user){
		System.out.println("before save"+user.toString());
		user = userService.saveUser(user);
		System.out.println("after save "+user.toString());
		return  new ResponseEntity<User>(user,HttpStatus.OK);
		
	}
	
	@GetMapping("/userRegistration")
	public List<User> getUsers(){
		
		return userService.findAll();
		
	}

}
