package com.devadictos.java.redis.showcase.sample2;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.devadictos.java.redis.showcase.sample2.dto.Box;

@Component("jsonKeys")
public class JsonKeyImpl implements JsonKey {
	
	
	@Resource(name="jsonKeyRedisTemplate")
	private RedisTemplate<String, Box> redisTemplate;

	public void insertKey(String key, Box box) {
		this.redisTemplate.opsForValue().set(key, box);
		

	}

	public Box getKey(String key) {
		return this.redisTemplate.opsForValue().get(key);
	}

	public void insertKeyWithExpire(String key, Box box, long timeInMilis) {
		this.redisTemplate.opsForValue().set(key, box, timeInMilis, TimeUnit.MILLISECONDS);
		
	}

	

	
}
