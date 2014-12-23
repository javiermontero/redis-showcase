package com.devadictos.java.redis.showcase.sample1;

public interface NormalKey {
	
	
	void insertKey(String key, String value);
	
	void insertKeyWithExpire(String key, String value, long timeInMilis);
	
	String getKey(String key);

}
