package com.aprendendojava.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendojava.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}	
