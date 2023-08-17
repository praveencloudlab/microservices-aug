package com.cts.ecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ecart.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
}
