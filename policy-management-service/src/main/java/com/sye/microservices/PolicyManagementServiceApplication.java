package com.sye.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sye.microservices.domain.Role;
import com.sye.microservices.domain.User;
import com.sye.microservices.repository.RoleRepository;
import com.sye.microservices.service.UserService;

@SpringBootApplication
public class PolicyManagementServiceApplication implements CommandLineRunner  {
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleRepository roleRepository; 
	
	public static void main(String[] args) {
		SpringApplication.run(PolicyManagementServiceApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Role adminRole= new Role("ADMIN");
		Role userRole= new Role("USER");
		roleRepository.save(adminRole);
		roleRepository.save(userRole);
		
		User admin = userService.findUserByUserName("admin");
		if(admin ==null) {
			admin = new User("admin","welcome1","admin","system");
			userService.saveUserWithAdmin(admin);
			System.out.println("Admin created!!!");
		}else {
			System.out.println("Admin exists!!!");
		}
		
		User user = userService.findUserByUserName("user");
		if(user ==null) {
			user = new User("user","welcome1","user","system");
			userService.saveUser(user);
			System.out.println("Default user created!!!");
		}else {
			System.out.println("Default user exists!!!");
		}
		
	}
}
