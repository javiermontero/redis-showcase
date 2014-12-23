package com.devadictos.java.redis.showcase.sample5;

import java.util.Collection;
import java.util.List;

import com.devadictos.java.redis.showcase.sample5.dto.LeaderBoard;

public interface SortedSetKey {
	
	
	void addPlayer(String key, Long player, double score);	
	
	Long getPositionByUserInTournament(String key, Long player);	
	
	long addPlayerDelta(String key, Long player, double delta);	
	
	List<LeaderBoard> getAllListLeaderBoardByKey(String key);
	
	void deleteKey(String key);
	void createKey(String key);

	Long getNumPlayersByTournament(String key);
	
	Collection<Long> getPlayersByTournament(String key);

	List<LeaderBoard> getLeaderBoardByKeyAndPositions(String key,Long numberOfElements);

}
