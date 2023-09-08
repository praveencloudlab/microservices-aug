package com.cts.ecart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "stock_info")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stockId;
	private int stock;

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stock=" + stock + "]";
	}

}
