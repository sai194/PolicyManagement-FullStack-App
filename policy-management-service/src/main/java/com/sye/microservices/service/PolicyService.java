package com.sye.microservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sye.microservices.domain.Policy;
import com.sye.microservices.repository.PolicyRepository;

@Service
public class PolicyService  {

	@Autowired
	PolicyRepository policyRepository;
	
	public List<Policy> findPolicies(){
		
		return policyRepository.findAll();
	}
   public List<Policy> findPoliciesByUserName(String username){
		
		return policyRepository.findByUsername(username);
	}
	
	public Policy findPolicy(Long id){
		
		return policyRepository.findById(id).orElse(null);
	}
	
	public void deletePolicy(Long id) {
		 policyRepository.deleteById(id);
	}
	
	public Policy  savePolicy(Policy p) {
		//if(p.getId()==-1 || p.getId()==0)
	
		//System.out.println(p.toString());
		return policyRepository.save(p);
	}
}
