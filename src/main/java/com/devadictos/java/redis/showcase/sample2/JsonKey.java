package com.devadictos.java.redis.showcase.sample2;

import com.devadictos.java.redis.showcase.sample2.dto.Box;

public interface JsonKey {
	
	
	void insertKey(String key, Box box);
	
	void insertKeyWithExpire(String key, Box box, long timeInMilis);
	
	Box getKey(String key);

}
