package com.devadictos.java.redis.showcase.sample5.dto;

public class LeaderBoard {

	private Long player;
	
	private Long position;
	
	private Long score;

	public Long getPlayer() {
		return player;
	}

	public void setPlayer(Long player) {
		this.player = player;
	}

	public Long getPosition() {
		return position;
	}

	public void setPosition(Long position) {
		this.position = position;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("LeaderBoard [player=").append(player)
				.append(", position=").append(position).append(", score=")
				.append(score).append("]");
		return builder.toString();
	}

	
	
}
