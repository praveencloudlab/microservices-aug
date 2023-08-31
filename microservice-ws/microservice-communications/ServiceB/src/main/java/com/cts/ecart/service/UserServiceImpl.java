package com.cts.ecart.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl {
	
	// microservice-A url
	final String URL="http://localhost:8081/api/greetings"; 
	
	private RestTemplate rt=new RestTemplate();
	
	public String getGreetings(String name) {
		
		String greetMsg = rt.getForObject(URL+"/"+name, String.class);
		
		return greetMsg;
		
	}

}
