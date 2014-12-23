package com.devadictos.java.redis.showcase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.devadictos.java.redis.showcase.sample1.NormalKey;

public class Sample1 {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Sample1.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:/META-INF/spring/redis-showcase-base-applicationContext.xml","classpath:/META-INF/spring/redis-showcase-keys-applicationContext.xml");
		final NormalKey normalKey = appContext.getBean(NormalKey.class);
		final String key= "redis:sample1";
		final String data = "sample1.data";
		normalKey.insertKeyWithExpire(key, data, 2000);
		final String returnedData = normalKey.getKey(key);
		LOGGER.info("ReturnedData {}", returnedData);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			//NOTHING			
		}
		LOGGER.info("ReturnedData must be null : {}", normalKey.getKey(key));

	}

}
