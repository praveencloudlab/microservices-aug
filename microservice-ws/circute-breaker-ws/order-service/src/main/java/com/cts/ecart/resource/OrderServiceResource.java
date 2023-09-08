package com.cts.ecart.resource;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

import com.cts.ecart.entity.Order;
import com.cts.ecart.service.OrderServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("api/orders")
@RefreshScope
public class OrderServiceResource {

	@Autowired
	private OrderServiceImpl orderService;

	@PostMapping("/{user}")
	@CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
	@TimeLimiter(name = "inventory")
	@Retry(name = "inventory")
	public CompletableFuture<List<Order>> placeOrder(@PathVariable String user) {
		return CompletableFuture.supplyAsync(() -> orderService.placeOrder(user));
	}

	@GetMapping("/listOrders/{userId}")
	public List<Order> findAllOrders(@PathVariable int userId) {
		return orderService.findAllOrders(userId);
	}

	public CompletableFuture<String> fallbackMethod(String user, RuntimeException runtimeException) {
		// return null;
		System.out.println(">>>>>>>>> Fallback <<<<<<<<<");
		return CompletableFuture.supplyAsync(() -> "Oops! Something went wrong. Please order after sometime");
		// return new ResponseEntity<>("Oops! Something went wrong. Please order after
		// sometime",HttpStatus.OK);
		// return "Oops! Something went wrong. Please order after sometime";
	}

}
