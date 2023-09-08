package com.cts.ecart.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ecart.entity.Item;
import com.cts.ecart.entity.ItemLine;
import com.cts.ecart.entity.Product;
import com.cts.ecart.service.CartService;

@RestController
@RequestMapping("/api/cart/{user}")
public class CartResource {
	@Autowired
	private CartService cartService;
	
	@PostMapping("/{productId}/{qty}")
	public ItemLine addToCart(@PathVariable("user")String user,@PathVariable("productId")int productId,@PathVariable("qty")int qty) {
		return cartService.save(user,productId,qty);
	}
	
	@GetMapping
	public List<ItemLine> getCartItems(@PathVariable("user")String user){
		return cartService.findAll(user);
	}
	
	@DeleteMapping
	public void clearCart(@PathVariable("user")String user) {
		cartService.clear(user);
	}
}
