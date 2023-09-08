package com.cts.ecart.resouce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ecart.entity.Price;
import com.cts.ecart.service.PriceService;

@RestController
@RequestMapping("/api/price")
@CrossOrigin
@RefreshScope
public class PriceResource {

	@Autowired
	private PriceService priceService;

	@Value("${discount-code}")
	private String discountCode;

	// find price by price ID
	@GetMapping("/{priceId}")
	public Price findByPriceId(@PathVariable int priceId) {
		System.out.println("======================================================");
		System.out.println("PRICE-DISCOUNT CODE APPLIED :: " + discountCode);
		System.out.println("======================================================");
		return priceService.findPriceById(priceId);
	}

	@GetMapping("/product/{productId}")
	public double findPriceByProductId(@PathVariable int productId) {
		System.out.println("======================================================");
		System.out.println("PRICE-DISCOUNT CODE APPLIED :: " + discountCode);
		System.out.println("======================================================");

		return priceService.findByProductId(productId).getPrice();
	}

}
