package com.devadictos.java.redis.showcase.sample5;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.stereotype.Component;

import com.devadictos.java.redis.showcase.sample5.dto.LeaderBoard;

@Component("sortedSetKey")
public class SortedSetKeyImpl implements SortedSetKey {
	
	
	@Resource(name="keyRedisTemplate")
	private RedisTemplate<String, Long> redisTemplate;

	@Override
	public void addPlayer(String key, Long player, double score) {
		this.redisTemplate.boundZSetOps(key).add(player, score);
		
	}

	

	@Override
	public Long getPositionByUserInTournament(String key, Long player) {
		return this.redisTemplate.boundZSetOps(key).reverseRank(player) +1;
	}


	@Override
	public long addPlayerDelta(String key, Long player, double delta) {
		return this.redisTemplate.boundZSetOps( key).incrementScore(player, delta).longValue();
		
	}



	@Override
	public List<LeaderBoard> getAllListLeaderBoardByKey(String key) {
		return this.getLeaderBoardByKeyAndPositions(key, -1L);
	}
	
	@Override
	public List<LeaderBoard> getLeaderBoardByKeyAndPositions(String key, Long numberOfElements) {
		final Set<TypedTuple<Long>> data = this.redisTemplate.boundZSetOps(key).reverseRangeWithScores(0, numberOfElements);
		final List<LeaderBoard> leaderData = new LinkedList<LeaderBoard>();
		long position = 1;
		for (TypedTuple<Long> typedTuple : data) {
			final LeaderBoard leaderBoard = new LeaderBoard();
			leaderBoard.setPosition(position++);
			leaderBoard.setScore(typedTuple.getScore().longValue());			
			leaderBoard.setPlayer(typedTuple.getValue());
			leaderData.add(leaderBoard);			
		}
		return leaderData;
	}

	

	@Override
	public Long getNumPlayersByTournament(String key) {
		return this.redisTemplate.boundZSetOps(key).size();
	}

	@Override
	public Collection<Long> getPlayersByTournament(String key) {
		return this.redisTemplate.boundZSetOps(key).range(0, -1);
	}



	@Override
	public void deleteKey(String key) {
		this.redisTemplate.delete(key);
		
	}



	@Override
	public void createKey(String key) {
		this.redisTemplate.persist(key);
		
	}



	
	
	
}
