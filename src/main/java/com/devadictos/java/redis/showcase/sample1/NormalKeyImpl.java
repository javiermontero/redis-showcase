package com.devadictos.java.redis.showcase.sample1;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component("normalKeys")
public class NormalKeyImpl implements NormalKey {
	
	
	@Resource(name="keyRedisTemplate")
	private RedisTemplate<String, String> redisTemplate;

	public void insertKey(String key, String value) {
		this.redisTemplate.opsForValue().append(key, value);

	}

	public String getKey(String key) {
		return this.redisTemplate.opsForValue().get(key);
	}

	public void insertKeyWithExpire(String key, String value, long timeInMilis) {
		this.redisTemplate.opsForValue().set(key, value, timeInMilis, TimeUnit.MILLISECONDS);
		
	}

}
