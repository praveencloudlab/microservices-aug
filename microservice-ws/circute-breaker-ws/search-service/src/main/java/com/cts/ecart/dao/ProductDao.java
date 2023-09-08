package com.cts.ecart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ecart.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	// DSL => Domain Specific Language

	List<Product> findByProductTitleLike(String productTitle);

	List<Product> findByPrice_ProductPriceBetween(double startRange, double endRange);

	List<Product> findByPrice_ProductPriceGreaterThanEqual(double price);

	List<Product> findByPrice_ProductPriceLessThanEqual(double price);

	List<Product> findByBrand_BrandTitleLike(String brandTitle);

	List<Product> findByBrand_BrandId(int brandId);

	List<Product> findByCategory_CategoryTitleLike(String categoryTitle);

	List<Product> findByCategory_CategoryId(int categoryId);

}
