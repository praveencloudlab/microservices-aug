package com.cts.configclient.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.cts.configclient.model.Category;

@FeignClient(name="ecart-service",url = "http://localhost:8083")
public interface CategoryService {
	
	@GetMapping("/api/categories")
	List<Category> findAll();

}
