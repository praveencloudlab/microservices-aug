package com.cts.ecart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ecart.entity.Brand;
import com.cts.ecart.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	
	// DSL
	
	// filter product by title
	
	List<Product> findByProductTitleLike(String name);
	
	
	
	
}



