package com.cts.ecart.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ecart.entity.Product;
import com.cts.ecart.service.ProductService;

@RestController
@RequestMapping("api/products")
@CrossOrigin
@RefreshScope
public class SearchServiceResource {
	@Autowired
	private ProductService productService;
	
	@Value("${info}")
	private String information;

	@GetMapping("/{id}")
	public Product findById(@PathVariable int id) {

		System.out.println("=================================");
		System.out.println(information);
		System.out.println("=================================");

		return productService.findById(id);
	}

	@GetMapping
	public List<Product> findAll() {
		return productService.findAll();
	}

	@GetMapping("/filter/title/{productTitle}")
	public List<Product> findByProductTitle(@PathVariable String productTitle) {
		// TODO Auto-generated method stub
		return productService.findByProductTitle("%" + productTitle + "%");
	}

	@GetMapping("/filter/price/{startRange}/{endRange}")
	public List<Product> findByPriceRange(@PathVariable double startRange, @PathVariable double endRange) {
		// TODO Auto-generated method stub
		return productService.findByPriceRange(startRange, endRange);
	}

	@GetMapping("/filter/price/greater/{price}")
	public List<Product> findByPriceGreater(@PathVariable double price) {
		// TODO Auto-generated method stub
		return productService.findByPriceGreater(price);
	}

	@GetMapping("/filter/price/lesser/{price}")
	public List<Product> findBypriceLesser(@PathVariable double price) {
		// TODO Auto-generated method stub
		return productService.findBypriceLesser(price);
	}

	@GetMapping("/filter/brand/title/{brandTitle}")
	public List<Product> findByBrandTitle(@PathVariable String brandTitle) {
		// TODO Auto-generated method stub
		return productService.findByBrandTitle(brandTitle);
	}

	@GetMapping("/filter/brand/{brandId}")
	public List<Product> findByBrandId(@PathVariable int brandId) {
		// TODO Auto-generated method stub
		return productService.findByBrandId(brandId);
	}

	@GetMapping("/filter/category/title/{categoryTitle}")
	public List<Product> findByCategoryTitle(@PathVariable String categoryTitle) {
		// TODO Auto-generated method stub
		return productService.findByCategoryTitle(categoryTitle);
	}

	@GetMapping("/filter/category/{categoryId}")
	public List<Product> findByCategoryId(@PathVariable int categoryId) {
		// TODO Auto-generated method stub
		return productService.findByCategoryId(categoryId);
	}

	// CRUD OPERATIONS
	// ==========================
	@PostMapping
	public Product saveProduct(@RequestBody Product product) {
		// TODO Auto-generated method stub
		return productService.saveProduct(product);
	}

	@PostMapping("/saveAll")
	public List<Product> saveAllProducts(@RequestBody List<Product> products) {
		// TODO Auto-generated method stub
		return productService.saveAllProducts(products);
	}

	@DeleteMapping("/{productId}")
	public void deleteProductById(@PathVariable int productId) {
		productService.deleteProductById(productId);

	}

	@DeleteMapping
	public void deleteProduct(@RequestBody Product product) {
		productService.deleteProduct(product);
	}

}
