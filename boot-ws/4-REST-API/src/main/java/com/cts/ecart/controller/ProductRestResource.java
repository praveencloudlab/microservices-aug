package com.cts.ecart.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ecart.model.Product;

@RestController
public class ProductRestResource {
	
	
	@GetMapping("/{id}")
	public String f1(@PathVariable int id) {
		return "GET Mapping -- "+id;
	}
	@GetMapping("/filter/{name}")
	public String f111(@PathVariable String name) {
		return "GET Mapping -- "+name;
	}
	
	@GetMapping("/filter/{start}/{end}")
	public String f1111(@PathVariable int start,@PathVariable int end) {
		//
		return start+" and "+end;
	}
	@GetMapping
	public String f11() {
		return "GET Mapping";
	}
	
	@PostMapping
	public String f2() {
		return "POST Mapping";
	}
	
	@PostMapping("/save")
	public Product f22(@RequestBody Product prod) {
		System.out.println(prod);
		return prod;
	}
	
	@PutMapping
	public String f3() {
		return "PUT Mapping";
	}
	@PatchMapping
	public String f4() {
		return "PATCH Mapping";
	}
	@DeleteMapping
	public String f5() {
		return "DELETE Mapping";
	}
	

}
