package com.cts.ecart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.ecart.dao.CartRepository;
import com.cts.ecart.entity.Item;
import com.cts.ecart.entity.ItemLine;
import com.cts.ecart.entity.Product;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public ItemLine save(String user, int productId,int qty) {
		double price=getPrice(productId);
		Product product = findProduct(productId);
		if(product.getStock().getStock()>=qty) {
		ItemLine itemLine=new ItemLine();
		Item item=new Item(product.getProductId(), product.getProductTitle(), price);
		item.setItemTotal(price*qty);
		itemLine.setItem(item);
		itemLine.setQty(qty);
		cartRepository.save(user, itemLine);
		return  itemLine;
		}
		
		//Map<String, Object> msg=new HashMap<>();
		//msg.put("msg", "Product Id "+product.getProductId()+" quantity is out of stock. only "+product.getStock().getStock()+" items available in stock");
		return null;
	}

	@Override
	
	public List<ItemLine> findAll(String user) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartRepository.findAll(user);
	}

	@Override
	public void clear(String user) {
		cartRepository.clear(user);
	}

	@Override
	public Product findProduct(int productId) {
		return restTemplate.getForObject("http://localhost:8082/api/products/" + productId, Product.class);
	}

	@Override
	public double getPrice(int productId) {
		Double price = restTemplate.getForObject("http://localhost:8081/api/price/product/" + productId, double.class);
		System.out.println(">>>>>> DOUBLE:: " + price);
		return price;
	}

}
