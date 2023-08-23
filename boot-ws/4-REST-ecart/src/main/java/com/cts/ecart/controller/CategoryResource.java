package com.cts.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ecart.entity.Category;
import com.cts.ecart.repository.CategoryRepository;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@GetMapping
	public List<Category> listAll(){
		
		return categoryRepository.findAll();
		
	}
	
	@PostMapping
	public Category saveCategory(@RequestBody Category catObj) {
		
		return categoryRepository.save(catObj);
		
	}
	

}
