package com.sye.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sye.microservices.domain.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}