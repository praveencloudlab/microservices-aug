package com.cts.ecart.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "orders")
public class Order {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	private LocalDateTime orderDate;
	private String paymentStatus;
	private int qty;
	private double total;
	private String transactionId;
	private int productId;
	private int userId;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(LocalDateTime orderDate, String paymentStatus, int qty, double total, String transactionId,
			int productId, int userId) {

		this.orderDate = orderDate;
		this.paymentStatus = paymentStatus;
		this.qty = qty;
		this.total = total;
		this.transactionId = transactionId;
		this.productId = productId;
		this.userId = userId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", paymentStatus=" + paymentStatus + ", qty="
				+ qty + ", total=" + total + ", transactionId=" + transactionId + ", productId=" + productId
				+ ", userId=" + userId + "]";
	}

}
