package com.devadictos.java.redis.showcase.sample3;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component("setStringKey")
public class SetStringKeyImpl implements SetStringKey {
	
	
	@Resource(name="keyRedisTemplate")
	private RedisTemplate<String, String> redisTemplate;
	
	@Override
	public void insertKey(String key, List<String> values) {
		this.redisTemplate.opsForSet().add(key, values.toArray(new String[values.size()]));

	}
	
	@Override
	public String getKey(String key) {
		return this.redisTemplate.opsForValue().get(key);
	}

	@Override
	public Set<String> intersection(String principalKey,String key) {
		return this.redisTemplate.opsForSet().intersect(principalKey, key);
	}

	@Override
	public Set<String> union(String principalKey, List<String> keys) {
		return this.redisTemplate.opsForSet().union(principalKey, keys);
	}

	@Override
	public Set<String> differents(String principalKey, String key) {
		return this.redisTemplate.opsForSet().difference(principalKey, key);
	}

}
