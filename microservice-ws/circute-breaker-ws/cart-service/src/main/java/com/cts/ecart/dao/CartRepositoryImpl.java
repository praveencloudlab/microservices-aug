package com.cts.ecart.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.cts.ecart.entity.ItemLine;

@Repository
public class CartRepositoryImpl implements CartRepository {

	@Autowired
	private RedisTemplate<String, String> templte;

	@Resource(name = "redisTemplate")
	private ListOperations<String, ItemLine> listOps;

	@Override
	public ItemLine save(String user, ItemLine itemLine) {
		listOps.leftPush(user, itemLine);
		return itemLine;
	}

	@Override
	public List<ItemLine> findAll(String user) {
		return listOps.range(user, 0, -1);
	}

	@Override
	public void clear(String user) {
		templte.delete(user);
	}

}
