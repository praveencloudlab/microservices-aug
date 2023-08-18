package com.cts.ecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cts.ecart.entity.Product;
import com.cts.ecart.entity.ProductRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		ProductRepository prodRepo = context.getBean(ProductRepository.class);
	
		String images[]= {"img1.jpg","img2.jpg","img3.jpg"};
		
		//Product prod=new Product(1, "Laptop", "Dell", 60000, 10, 4.7, 34, "Dell", "Electronics", "img1.jpeg", images);
		
		//prodRepo.save(prod);
		
		prodRepo.findAll().forEach(System.out::println);
		
		
		
		
		
		
		
	}
	

}
