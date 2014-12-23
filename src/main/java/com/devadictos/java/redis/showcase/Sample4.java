package com.devadictos.java.redis.showcase;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.devadictos.java.redis.showcase.sample4.HashStringKey;

public class Sample4 {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Sample4.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:/META-INF/spring/redis-showcase-base-applicationContext.xml","classpath:/META-INF/spring/redis-showcase-hash-applicationContext.xml");
		final HashStringKey hashStringKey = appContext.getBean(HashStringKey.class);
		final String key = "redis:sample4";
		Map<Object, Object> values = new HashMap<Object, Object>(4);
		values.put("name", "javi");
		values.put("surname", "montero");
		values.put("age", 33);
		values.put("location", "Santiago de Compostela");
		hashStringKey.insertKey(key, values);
		LOGGER.info("Key name  {}", hashStringKey.getFieldFromKey(key, "name"));
		LOGGER.info("All fields  {}", hashStringKey.getKey(key));
		hashStringKey.deleteField(key, "name");
		LOGGER.info("All fields  {}", hashStringKey.getKey(key));
		hashStringKey.delete(key);		
	}
	
	


}
