package com.devadictos.java.redis.showcase.sample3;

import java.util.List;
import java.util.Set;

public interface SetStringKey {
	
	
	void insertKey(String key, List<String> values);
	
	String getKey(String key);

	Set<String> intersection(String principalKey, String key);
	
	Set<String> union(String principalKey, List<String> keys);
	
	Set<String> differents(String principalKey, String key);

}
