package com.aprendendojava.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendojava.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}	
