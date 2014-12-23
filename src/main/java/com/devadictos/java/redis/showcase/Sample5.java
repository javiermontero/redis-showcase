package com.devadictos.java.redis.showcase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.devadictos.java.redis.showcase.sample5.SortedSetKey;

public class Sample5 {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Sample5.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:/META-INF/spring/redis-showcase-base-applicationContext.xml","classpath:/META-INF/spring/redis-showcase-sortedset-applicationContext.xml");
		final SortedSetKey sortedSetKey = appContext.getBean(SortedSetKey.class);
		final String key = "redis:sample5";
		sortedSetKey.createKey(key);
		
		for (long i = 1; i <= 15; i++) {
			sortedSetKey.addPlayer(key, i, i*10);			
		}
		for (long i = 1; i <= 15; i++) {
			LOGGER.info("Player {}, Score {}.", i, sortedSetKey.addPlayerDelta(key, i, i*10));			
		}
		LOGGER.info("Num players {}",sortedSetKey.getNumPlayersByTournament(key));
		LOGGER.info("The position of the player 12 is {} ",sortedSetKey.getPositionByUserInTournament(key, 12L));
		LOGGER.info("Posititons between 1 and 10:  {}" , sortedSetKey.getLeaderBoardByKeyAndPositions(key, 10L));
		LOGGER.info("All Posititons :  {}" , sortedSetKey.getAllListLeaderBoardByKey(key));
		sortedSetKey.deleteKey(key);	
	}
	
	


}
