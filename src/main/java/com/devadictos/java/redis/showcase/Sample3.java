package com.devadictos.java.redis.showcase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.devadictos.java.redis.showcase.sample3.SetStringKey;

public class Sample3 {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Sample3.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String keyAtleti= "redis:atleti";
		final String keySpain= "redis:spain";
		final String keyUruguay= "redis:uruguay";
		final SetStringKey setStringKey = loadKeysAndGetSetStringkey(keyAtleti, keySpain, keyUruguay);
		final Set<String> returnedData = setStringKey.intersection(keyAtleti, keySpain);
		LOGGER.info("ReturnedData {}", returnedData);
		final List<String> keys = new ArrayList<String>(2);
		keys.add(keyUruguay);
		keys.add(keySpain);
		final Set<String> unionAll = setStringKey.union(keyAtleti, keys);
		LOGGER.info("unionAll {}", unionAll);
		Set<String> differents = setStringKey.differents(keyAtleti, keySpain);
		LOGGER.info("differents {}", differents);
		differents = setStringKey.differents(keySpain,keyAtleti);
		LOGGER.info("differents Spain {}", differents);
	}
	
	
	public static  SetStringKey loadKeysAndGetSetStringkey(String keyAtleti, String keySpain, String keyUruguay) {
		final ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:/META-INF/spring/redis-showcase-base-applicationContext.xml","classpath:/META-INF/spring/redis-showcase-set-applicationContext.xml");
		final SetStringKey setStringKey = appContext.getBean(SetStringKey.class);
		setStringKey.insertKey(keyAtleti, appContext.getBean("atleti", List.class));
		setStringKey.insertKey(keySpain, appContext.getBean("spain", List.class));
		setStringKey.insertKey(keyUruguay, appContext.getBean("uruguay", List.class));
		return setStringKey;
		
	}

}
