package com.redis.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;

@Component
public class RedisService {

	@Autowired
	private RedisProperty redisProperty;
	
	public RedisService() {
		
	}
	
	public boolean ConnectService() {
		
		Jedis jedis = new Jedis(redisProperty.getHost(),Integer.parseInt(redisProperty.getPort()),redisProperty.isSslUsed());
		//jedis.auth(redisProperty.getPassword());
		String Response = jedis.ping();
		System.out.println(Response);
		return Response.equalsIgnoreCase("PONG");
	}

}
