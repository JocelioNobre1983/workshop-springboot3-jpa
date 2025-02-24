package com.aprendendojava.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendojava.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
}	
