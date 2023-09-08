package com.cts.ecart.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ecart.entity.UserInfo;

public interface UserDao extends JpaRepository<UserInfo, Integer> {

	Optional<UserInfo> findByUserName(String userName);
	Optional<UserInfo> findByEmail(String email);

}
