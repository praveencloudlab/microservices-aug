package com.cts.ecart.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ecart.service.UserServiceImpl;

@RestController
@RequestMapping("/api/users")
public class UserResource {
	
	@Autowired
	private UserServiceImpl userService;
	
	
	@GetMapping("/{name}")
	public String getGreetings(@PathVariable String name) {
		
		String msg = userService.getGreetings(name);
		
		return msg;
	}

}
