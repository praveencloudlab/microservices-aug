package com.cts.ecart.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.ecart.entity.ItemLine;

@FeignClient(name = "cart-service",url = "http://localhost:8083/api/cart")
public interface CartServiceProxy {
	
	@GetMapping("/{user}")
	public ItemLine[] getCartItems(@PathVariable String user);
	
	@DeleteMapping("/{user}")
	public void deleteCartItems(@PathVariable String user);

}
