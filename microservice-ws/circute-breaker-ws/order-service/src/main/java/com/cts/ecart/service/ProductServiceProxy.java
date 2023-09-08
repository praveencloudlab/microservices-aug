package com.cts.ecart.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.ecart.entity.Product;

@FeignClient(name = "search-service",url = "http://localhost:8082/api/products")
public interface ProductServiceProxy {
	@GetMapping("/{productId}")
	Product findProduct(@PathVariable int productId); 

}
