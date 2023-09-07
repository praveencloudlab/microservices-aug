package com.cts.ecart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.ecart.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
		
	
	 // DSL : Domain specific language
	
	 List<Category> findByCategoryTitle(String name);
	 List<Category> findByCategoryTitleLike(String name);
	 
	 @Query(name = "q1",value = "from com.cts.ecart.entity.Category as c where c.categoryTitle like :name")
	 List<Category> filterCategories(String name);
	 
	 
	
	
	

}
