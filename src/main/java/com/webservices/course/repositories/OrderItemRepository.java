package com.webservices.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservices.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	
	
}
