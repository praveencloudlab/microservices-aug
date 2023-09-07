package com.cts.configclient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.configclient.model.Category;

@Service
public class CategoryServiceImpl {
	
	@Autowired
	private CategoryService cs;
	
	public List<Category> findAllCategories(){
		return cs.findAll();
	}
	
	

}
