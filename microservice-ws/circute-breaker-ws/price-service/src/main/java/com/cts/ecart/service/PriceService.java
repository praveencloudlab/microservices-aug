package com.cts.ecart.service;

import com.cts.ecart.entity.Price;

public interface PriceService {

	// get price by price ID
	Price findPriceById(int id);

	//get price by product ID
	Price findByProductId(int productId);

}