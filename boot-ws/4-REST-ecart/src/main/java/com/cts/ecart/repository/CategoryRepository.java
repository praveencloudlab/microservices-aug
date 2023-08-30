package com.cts.ecart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ecart.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	// DSL Domain Specific language
	
	// find all categories with category Title
	
	List<Category> findByCategoryTitleLike(String name);
	Category findByCategoryTitle(String name);
	
	
	
	
	
	
	
	
}
