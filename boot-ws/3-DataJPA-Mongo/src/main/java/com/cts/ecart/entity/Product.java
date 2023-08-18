package com.cts.ecart.entity;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "products")
public class Product {

	@Id
	private int productId;
	private String productTitle;
	private String description;
	private double price;
	private double discountPercentage;
	private double rating;
	private int stock;
	private String brand;
	private String category;
	private String thumbnail;
	private String[] images;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String productTitle, String description, double price, double discountPercentage,
			double rating, int stock, String brand, String category, String thumbnail, String[] images) {
		super();
		this.productId = productId;
		this.productTitle = productTitle;
		this.description = description;
		this.price = price;
		this.discountPercentage = discountPercentage;
		this.rating = rating;
		this.stock = stock;
		this.brand = brand;
		this.category = category;
		this.thumbnail = thumbnail;
		this.images = images;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String[] getImages() {
		return images;
	}

	public void setImages(String[] images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productTitle=" + productTitle + ", description=" + description
				+ ", price=" + price + ", discountPercentage=" + discountPercentage + ", rating=" + rating + ", stock="
				+ stock + ", brand=" + brand + ", category=" + category + ", thumbnail=" + thumbnail + ", images="
				+ Arrays.toString(images) + "]";
	}

}
