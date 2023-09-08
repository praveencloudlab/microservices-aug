package com.cts.ecart.service;

import com.cts.ecart.entity.Product;

public interface ProductInventoryUpdate {

	//update inventory information 
	Product updateInventory(int productId, int quantity);

}