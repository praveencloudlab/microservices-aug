package com.cts.configclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "config-client2",url = "http://localhost:8081")
public interface ColorService {
	
	@GetMapping("/api/test")
	public String getColorName();
	
	
}
