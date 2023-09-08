package com.cts.ecart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ecart.entity.Order;
import com.cts.ecart.entity.UserInfo;

public interface UserDao extends JpaRepository<UserInfo, Integer> {

	UserInfo findByUserNameLike(String userName);
}
