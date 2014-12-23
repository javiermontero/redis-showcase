package com.devadictos.java.redis.showcase.sample5.serializer;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;

public class LongSerializer implements RedisSerializer<Long> {
	
	
	private StringRedisSerializer serializer;
	
	@Override
	public byte[] serialize(Long t) throws SerializationException {
		if (t!=null) {
			return this.serializer.serialize(t.toString());
		}else {
			return new byte[0];
		}
	}

	@Override
	public Long deserialize(byte[] bytes) throws SerializationException {
		final String sValue = this.serializer.deserialize(bytes);
		if (sValue==null) {
			return 0L;
		}		
		return Long.valueOf(sValue);
	}



	public void setSerializer(StringRedisSerializer serializer) {
		this.serializer = serializer;
	}



}
