package com.cts.ecart.service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.ecart.controller.Sender;
import com.cts.ecart.dao.OrderDao;
import com.cts.ecart.dao.UserDao;
import com.cts.ecart.entity.ItemLine;
import com.cts.ecart.entity.Order;
import com.cts.ecart.entity.Product;
import com.cts.ecart.entity.UserInfo;

@Service
public class OrderServiceImpl {
	
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private Sender sender;

	//private RestTemplate restTemplate = new RestTemplate();
	//private RestTemplate productTemplate = new RestTemplate();
	//private RestTemplate cartTemplate = new RestTemplate();
	
	@Autowired
	private CartServiceProxy cartServiceProxy;
	@Autowired
	private ProductServiceProxy productServiceProxy;

	//private final String CART_BASE_URL = "http://localhost:8083/api/cart";
	
	// load all cart items of a specified user
	protected static SecureRandom random = new SecureRandom();

	public List<Order> placeOrder(String user) {

		ItemLine[] cartItems = cartServiceProxy.getCartItems(user);
		System.out.println(">> ITEMS SIZE::: "+cartItems.length);
		
		if(cartItems.length==0) {
			System.out.println(">>>>>> No ITEMS TO ORDER IN CART. TERMINATING");
			return null;
		}
		
		//ItemLine[] cartItems = restTemplate.getForObject(CART_BASE_URL + "/" + user, ItemLine[].class);
		List<Order> orders = new ArrayList<>();
		UserInfo userInfo = userDao.findByUserNameLike(user);

		System.out.println(">>> user:: "+userInfo);
		Map<String, Object> orderInfo=new HashMap<String, Object>();
		Map<String, Object> inventoryInfo=new HashMap<String, Object>();
		
		
		
		for (ItemLine itemLine : cartItems) {

			Product product = productServiceProxy.findProduct(itemLine.getItem().getId());
			if(!(product.getStock().getStock()>=itemLine.getQty())) {
				return null;	
			}
			//Product product = productTemplate.getForObject("http://localhost:8082/api/products/" + itemLine.getItem().getId(), Product.class);
			String transactionNumber = Math.abs(random.nextLong()) + "";
			long orderId=Math.abs(random.nextLong())+System.currentTimeMillis();


			Order order = new Order();
			order.setOrderId(orderId);
			order.setOrderDate(LocalDateTime.now());
			order.setProductId(product.getProductId());
			order.setPaymentStatus("Success");
			order.setQty(itemLine.getQty());
			order.setTotal(itemLine.getItem().getItemTotal());
			order.setTransactionId(transactionNumber);
			order.setUserId(userInfo.getUserId());
			//orderDao.save(order);
			orders.add(order); // save the order
			
			// Clear cart items : REST CALL to the cart-service
			cartServiceProxy.deleteCartItems(user);
		    //cartTemplate.delete(CART_BASE_URL+"/"+user);
			
			
			
			inventoryInfo.put("PRODUCT_ID", product.getProductId());
			inventoryInfo.put("QUANTITY", itemLine.getQty());

			
			orderInfo.put("ORDER_ID", orderId);
			orderInfo.put("ORDER_DATE",order.getOrderDate());
			orderInfo.put("TRANSACTION_ID", order.getTransactionId());
			orderInfo.put("QUANTITY", order.getQty());
			orderInfo.put("PRODUCT_PRICE", +itemLine.getItem().getPrice());
			orderInfo.put("TOTAL", order.getTotal());
			orderInfo.put("USER_ID", userInfo.getUserName());
			orderInfo.put("PRODUCT_NAME", product.getProductTitle());

		}

		orderDao.saveAll(orders);
		
		// Send order information to the INVENTORYQ 
		 sender.updateInventory(inventoryInfo);
	
		//send order information to the EMAIL SERVICE
		 sender.sendEmail(orderInfo);
		
		return orders;
	}
	
	
	
	
	
	
	// List orders of a user
	
	public List<Order> findAllOrders(int userId){
		return orderDao.findAllOrders(userId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
