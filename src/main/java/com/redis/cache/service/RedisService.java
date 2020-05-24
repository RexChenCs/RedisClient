package com.redis.cache.service;

import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;

@Component
public class RedisService {

	@Autowired
	private RedisProperty redisProperty;
	
	private Jedis jedis;
	
	public RedisService() {
		
	}
	
	public boolean ConnectService() {
		String Response = "";
		try {
			jedis = new Jedis(redisProperty.getHost(),Integer.parseInt(redisProperty.getPort()),redisProperty.isSslUsed());
			if(!redisProperty.getPassword().isEmpty()) {
				jedis.auth(redisProperty.getPassword());
			}
			Response = jedis.ping();
			System.out.println(Response);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Connection Fail: "+ e.getMessage());
		}
		return Response.equalsIgnoreCase("PONG");
	}
	
	public String [] SearchAllKey(String key){
		Set<String> keys =  jedis.keys(key); 	
		return keys.toArray(new String[keys.size()]);
	}
	
	public String SearchValueByKey(String searchKey){
		String [] keys = SearchAllKey(searchKey);
        if(keys.length == 0){
            return "Does not fidn the values of all the specified keys";
        }
        List<String> values = jedis.mget(keys);
        String result = "", resultPair;
        int i = 0;
        for(String key: keys) {
        	resultPair = key + ":" + "[" + values.get(i) +"]" + System.lineSeparator();
        	result += resultPair;
        }	
        return result;

	}
	
	
	public void Disconnect() {
		JOptionPane.showMessageDialog(null, "Disconnect");
		jedis.close();
	}

}
