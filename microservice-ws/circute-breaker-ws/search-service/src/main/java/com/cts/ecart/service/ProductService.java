package com.cts.ecart.service;

import java.util.List;

import com.cts.ecart.entity.Product;

public interface ProductService {
	
	Product findById(int productId);
	List<Product> findAll();
	List<Product> findByProductTitle(String productTitle);
	List<Product> findByPriceRange(double startRange,double endRange);
	List<Product> findByPriceGreater(double price);
	List<Product> findBypriceLesser(double price);
	List<Product> findByBrandTitle(String brandTitle);
	List<Product> findByBrandId(int brandId);
	List<Product> findByCategoryTitle(String categoryTitle);
	List<Product> findByCategoryId(int categoryId);
	Product saveProduct(Product product);
	List<Product> saveAllProducts(List<Product> products);
	void deleteProductById(int productId);
	void deleteProduct(Product product);
	

}
