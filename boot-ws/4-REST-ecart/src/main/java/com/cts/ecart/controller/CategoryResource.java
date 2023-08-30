package com.cts.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ecart.entity.Brand;
import com.cts.ecart.entity.Category;
import com.cts.ecart.entity.Product;
import com.cts.ecart.repository.BrandRepository;
import com.cts.ecart.repository.CategoryRepository;
import com.cts.ecart.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class CategoryResource {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private ProductRepository productRepository;
	
	
	
	// list all products
	@GetMapping("/products")
	public List<Product> findAllProducts(){
		return productRepository.findAll();
	}
	
	// filter products by productTitle
		@GetMapping("/products/filter/all/{productTitle}")
		public List<Product> findAllProductsByName(@PathVariable String productTitle) {
			return productRepository.findByProductTitleLike("%"+productTitle+"%");
		}
	
	
	@GetMapping("/categories")
	public List<Category> listAllCategories(){
		return categoryRepository.findAll();
	}
	

	// gel all brands
	@GetMapping("/brands")
	public List<Brand> findAllBrands(){
		return brandRepository.findAll();
	}
	
	// filter categories by categoryTitle
	@GetMapping("/categories/filter/all/{categoryTitle}")
	public List<Category> findAllCategoriesByName(@PathVariable String categoryTitle) {
		return categoryRepository.findByCategoryTitleLike("%"+categoryTitle+"%");
	}
	
	// filter categories by categoryTitle
		@GetMapping("/categories/filter/{categoryTitle}")
		public Category findCategoryByName(@PathVariable String categoryTitle) {
			return categoryRepository.findByCategoryTitle(categoryTitle);
		}
	
	
	@PostMapping
	public Category saveCategory(@RequestBody Category catObj) {
		
		return categoryRepository.save(catObj);
		
	}
	

}
