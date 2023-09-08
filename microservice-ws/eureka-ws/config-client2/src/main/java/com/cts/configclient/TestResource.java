package com.cts.configclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.configclient.model.Category;
import com.cts.configclient.service.CategoryServiceImpl;
import com.cts.configclient.service.ColorServiceImpl;
@RestController
@RequestMapping("/api/client")
public class TestResource {
	
	
	
	@Autowired
	private ColorServiceImpl cs;
	
	@Autowired
	private CategoryServiceImpl catService;
	
	@GetMapping("/categories")
	public List<Category> findAll(){
		return catService.findAllCategories();
	}
	
	
	@GetMapping
	public String getColor() {
		return cs.getColorName();
	}

}
