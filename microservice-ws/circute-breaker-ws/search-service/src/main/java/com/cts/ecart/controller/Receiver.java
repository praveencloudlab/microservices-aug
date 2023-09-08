package com.cts.ecart.controller;

import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import com.cts.ecart.service.ProductInventoryUpdate;

@Controller
public class Receiver {
	
	@Autowired
	private ProductInventoryUpdate inventoryUpdate;
	
	@Bean
	public Queue f1() {
		return new Queue("INVENTORYQ", false);
	}
	
	
	@RabbitListener(queues = "INVENTORYQ")
	public void getOrderInfo(Map<String, Object> data) {
		
		int productId=(int) data.get("PRODUCT_ID");
		int quantity=(int) data.get("QUANTITY");
		
		System.out.println("=============================================");
		System.out.println("PRODUCT-SERVICE :: Updating inventory information");
		System.out.println("=============================================");
		inventoryUpdate.updateInventory(productId, quantity);
		
	}
	
	

}
