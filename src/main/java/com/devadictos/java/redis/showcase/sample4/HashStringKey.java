package com.devadictos.java.redis.showcase.sample4;

import java.util.Map;

public interface HashStringKey {
	
	
	void insertKey(String key, Map<Object, Object> values);

	Map<Object, Object> getKey(String key);

	Object getFieldFromKey(String key, String field);

	void delete(String key);

	void deleteField(String key, String field);
}
