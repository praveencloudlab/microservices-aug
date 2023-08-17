package com.cts.ecart.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductServiceImpl {
	
	@Transactional(propagation = Propagation.MANDATORY)
	public void placeOrder() {
		
		f1();
		f2();
		f3();
		
	}
	
	// process payment gateway
	void f3() {}
	// update stock info
	void f1() {}
	// send order email confirmation
	void f2() {}
	
	

}
