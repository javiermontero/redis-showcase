package com.devadictos.java.redis.showcase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.devadictos.java.redis.showcase.sample2.JsonKey;
import com.devadictos.java.redis.showcase.sample2.dto.Box;

public class Sample2 {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Sample2.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:/META-INF/spring/redis-showcase-base-applicationContext.xml","classpath:/META-INF/spring/redis-showcase-jsonkeys-applicationContext.xml");
		final JsonKey jsonkey = appContext.getBean(JsonKey.class);
		String key= "redis:sample2";
		Box data = new Box(1,2);
		jsonkey.insertKeyWithExpire(key, data, 2000);
		final Box returnedData = jsonkey.getKey(key);
		LOGGER.info("ReturnedData {}", returnedData);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			//NOTHING			
		}
		LOGGER.info("ReturnedData must be null : {}", jsonkey.getKey(key));
	}

}
