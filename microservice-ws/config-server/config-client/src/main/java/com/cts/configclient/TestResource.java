package com.cts.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestResource {
	
	@Value("${color}")
	private String colorName;
	
	@GetMapping
	public String getColor() {
		return "Favorate Color is "+colorName;
	}
	
	
	
	
	

}
