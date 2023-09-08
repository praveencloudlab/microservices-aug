package com.cts.ecart.entity;

import java.io.Serializable;

public class ItemLine implements Serializable {

	private static final long serialVersionUID = 1L;

	public ItemLine() {
		// TODO Auto-generated constructor stub
	}

	public ItemLine(int qty, Item item) {
		this.qty = qty;
		this.item = item;
	}

	private int qty;
	private Item item;

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "ItemLine [qty=" + qty + ", item=" + item + "]";
	}

}
