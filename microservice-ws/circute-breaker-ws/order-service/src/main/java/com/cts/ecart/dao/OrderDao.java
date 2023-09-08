package com.cts.ecart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.ecart.entity.Order;

public interface OrderDao extends JpaRepository<Order, Long> {
	
	
	
	
	
	@Query(name="q1",value = "from com.cts.ecart.entity.Order o where o.userId =:userId")
	List<Order> findAllOrders(int userId);

}
