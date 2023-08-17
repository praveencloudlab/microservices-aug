package com.cts.ecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.cts.C3;
import com.cts.ecart.repository.CategoryRepository;

@SpringBootApplication // auto discovery
public class Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ac= SpringApplication.run(Application.class, args);
		CategoryRepository catRepo = ac.getBean(CategoryRepository.class);
		
		catRepo.findAll().forEach(System.out::println);
		
		
		
		
	}

}
