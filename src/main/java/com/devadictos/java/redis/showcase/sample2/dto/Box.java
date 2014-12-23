package com.devadictos.java.redis.showcase.sample2.dto;

public class Box {

	private int size;
	
	private int high;	
	

	
	public Box(){}
	
	public Box(int size, int high) {
		super();
		this.size = size;
		this.high = high;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder(60);
		builder.append("Box [size=").append(size).append(", high=")
				.append(high).append("]");
		return builder.toString();
	}
	
	
	
	
	

}
