package com.cts.ecart.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ecart.entity.Category;
import com.cts.ecart.repository.CategoryRepository;


@RestController
@RequestMapping("/api/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryRepository cr;
	
	@GetMapping
	public List<Category> findAllCategories(){
		return cr.findAll();
	}

}
