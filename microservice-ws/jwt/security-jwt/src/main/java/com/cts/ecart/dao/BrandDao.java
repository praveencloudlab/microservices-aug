package com.cts.ecart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ecart.entity.Brand;

public interface BrandDao extends JpaRepository<Brand, Integer> {

}
