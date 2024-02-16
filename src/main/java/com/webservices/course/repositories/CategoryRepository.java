package com.webservices.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservices.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	
	
}
