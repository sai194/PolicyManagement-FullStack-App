package com.sye.microservices.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sye.microservices.domain.Role;
import com.sye.microservices.domain.User;
import com.sye.microservices.repository.RoleRepository;
import com.sye.microservices.repository.UserRepository;

@Service("userService")
@Transactional
public class UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserService(UserRepository userRepository, RoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public User findUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	public void saveUserWithAdmin(User user) {
		User userExists = userRepository.findByUserName(user.getUserName());
		if (userExists != null && userExists.getRoles() != null && userExists.getRoles().size() > 0) {
			// user already exists
		} else {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setActive(1);
			Role userRole = roleRepository.findByRole("ADMIN");
			user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
			userRepository.save(user);
		}
	}
	
	public User saveUser(User user) {
		User userExists = userRepository.findByUserName(user.getUserName());	
		if (userExists != null ) {
			System.out.print("user exists");
			System.out.println(user.toString());
			//return false;
		} else {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setActive(1);
			Role userRole = roleRepository.findByRole("USER");
			user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
			user =userRepository.save(user);
			System.out.println("service save"+user.toString());
		}
		return user;
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}