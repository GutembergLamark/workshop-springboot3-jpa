package com.gtmsoftware.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtmsoftware.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
