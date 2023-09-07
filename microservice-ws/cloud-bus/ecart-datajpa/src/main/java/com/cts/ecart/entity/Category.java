package com.cts.ecart.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity(name = "categories")
public class Category {

	@Id
	@GeneratedValue
	private int categoryId;
	private String categoryTitle;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="category_brands",
		joinColumns = {@JoinColumn(name="category_id")},
		inverseJoinColumns = {@JoinColumn(name="brand_id")})
	private List<Brand> brandInfo=new ArrayList<Brand>();

	
	
	public List<Brand> getBrandInfo() {
		return brandInfo;
	}

	public void setBrandInfo(List<Brand> brandInfo) {
		this.brandInfo = brandInfo;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryTitle=" + categoryTitle + ", brandInfo=" + brandInfo
				+ "]";
	}
	
	

}
