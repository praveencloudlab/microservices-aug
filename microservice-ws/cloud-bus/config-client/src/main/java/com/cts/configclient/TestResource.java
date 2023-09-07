package com.cts.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/test")
@RefreshScope
public class TestResource {
	
	@Value("${color}")
	private String colorName;
	
	@Value("${name}")
	private String personName;
	
	@GetMapping
	public String getColor() {
		return "Favorate Color is "+colorName;
	}
	
	
	@GetMapping("/name")
	public String getName() {
		return personName;
	}
	
	
	
	
	
	
	
	
	
	

}
