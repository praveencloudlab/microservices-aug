package com.cts.ecart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ecart.entity.Stock;

public interface StockDao  extends JpaRepository<Stock, Integer> {

}
