package com.cts.ecart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "price_info")
public class Price {

	@Id
	@GeneratedValue
	private int priceId;
	@Column(name = "price")
	private double productPrice;

	public int getPriceId() {
		return priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Price [priceId=" + priceId + ", productPrice=" + productPrice + "]";
	}

}
