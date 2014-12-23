package com.devadictos.java.redis.showcase.sample4;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component("hashStringKey")
public class HashStringKeyImpl implements HashStringKey {
	
	
	@Resource(name="keyRedisTemplate")
	private RedisTemplate<String, String> redisTemplate;
	
	@Override
	public void insertKey(String key, Map<Object, Object> values) {
		this.redisTemplate.opsForHash().putAll(key, values);

	}
	
	@Override
	public Map<Object, Object> getKey(String key) {
		return this.redisTemplate.opsForHash().entries(key);
	}

	@Override
	public Object getFieldFromKey(String key,String field) {
		return this.redisTemplate.opsForHash().get(key, field);
	}

	@Override
	public void delete(String key) {
		this.redisTemplate.delete(key);
	}

	@Override
	public void deleteField(String key, String field) {
		this.redisTemplate.opsForHash().delete(key, field);
		
	}

	

}
