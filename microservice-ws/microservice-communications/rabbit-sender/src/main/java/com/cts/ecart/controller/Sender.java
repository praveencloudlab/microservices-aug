package com.cts.ecart.controller;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class Sender {
	@Autowired
	private RabbitTemplate rt;
	
	
	@Autowired
	public Sender(RabbitTemplate rt) {
		super();
		this.rt = rt;
	}

	@Bean
	 Queue f1() {
		return new Queue("Q1",false);
	}
	
	@Bean
	 void f2() {
		
		rt.convertAndSend("Q1","This is Fifth message");
		
	}
	

}
