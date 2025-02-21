package com.aprendendojava.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aprendendojava.course.entities.User;
import com.aprendendojava.course.repositories.UserRepository;

@Service//autorização para injetar a dependencia
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll()
;	}
}
