package com.cts.ecart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ecart.entity.Price;

public interface PriceDao  extends JpaRepository<Price, Integer> {

}
