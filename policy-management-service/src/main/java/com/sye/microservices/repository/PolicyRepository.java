package com.sye.microservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sye.microservices.domain.Policy;

public interface PolicyRepository extends JpaRepository<Policy,Long>{

	List<Policy> findByUsername(String username);
	

}
