package com.cts.ecart.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greetings")
public class GreetingResource {
	
	@GetMapping("/{name}")
	public String greetings(@PathVariable String name) {
		return "Dear "+name+" Good Evening!";
	}
	
	
	
	

}
