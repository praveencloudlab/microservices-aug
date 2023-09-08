package com.cts.ecart.service;

import java.util.List;

import com.cts.ecart.entity.ItemLine;
import com.cts.ecart.entity.Product;

public interface CartService{

	public ItemLine save(String user, int productId,int qty);
	
	List<ItemLine> findAll(String user);

	void clear(String user);
	
	Product findProduct(int productId);
	
	double getPrice(int productId);

}
