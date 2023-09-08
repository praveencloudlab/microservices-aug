package com.cts.ecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.ecart.dao.PriceDao;
import com.cts.ecart.dao.ProductDao;
import com.cts.ecart.entity.Price;

@Service
public class PriceServiceImpl implements PriceService {
	
	@Autowired
	private PriceDao priceDao;
	@Autowired
	private ProductDao productDao;
	
	// get price by price ID
	@Override
	public Price findPriceById(int id) {
		return priceDao.findById(id).orElse(null);
	}
	
	//get price by product ID
	@Override
	public Price findByProductId(int productId) {
		return productDao.findById(productId).orElse(null).getPrice();
	}
}
