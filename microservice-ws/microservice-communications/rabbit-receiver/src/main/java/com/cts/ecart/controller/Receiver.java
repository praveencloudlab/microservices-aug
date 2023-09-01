package com.cts.ecart.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Controller;

@Controller
public class Receiver {
	
	
	@RabbitListener(queues = "Q1")
	public void getData(String msg) {
		System.out.println("====================================");
		System.out.println(msg);
		System.out.println("====================================");

		
	}

}
