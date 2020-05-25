package com.redis.cache.service;

import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.redis.cache.utils.SerializeUtil;

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
			if(redisProperty.isSslUsed()) {
				
			}
			Response = jedis.ping();
			System.out.println(Response);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Connection Fail: "+ e.getMessage());
		}
		return Response.equalsIgnoreCase("PONG");
	}
	
    public boolean existsCache(String key) {
        boolean ifExist;
        try {
        	ifExist = jedis.exists(key).booleanValue();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } 
        return ifExist;
    }
    
    public boolean existsHashCache(String key, String field) {
        boolean ifExist;
        try {
        	ifExist = jedis.hexists(key, field).booleanValue();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return ifExist;
    }
	
	public String [] SearchAllKey(String key){
		
		TokenReponse res = new TokenReponse();
		res.setName("TestTokenName");
		res.setTime(100);
		res.setToken("ABC");
		addCacheForObject("AToken", res);
		
		Set<String> keys =  jedis.keys(key); 	
		return keys.toArray(new String[keys.size()]);
	}
	
	public String SearchValueByKey(String searchKey){
		String [] keys = SearchAllKey(searchKey);
        if(keys.length == 0){
            return "Does not fidn the values of all the specified keys";
        }
        List<String> values = jedis.mget(keys);
        String result = "", resultPair = "";
        int i = 0;
        for(String key: keys) {
        	if(values.get(i).equals("nil")) { 
        		Object value = getCacheForObject(key);
        		String strValue = ToStringBuilder.reflectionToString(value);
        		if(value != null) {
        			resultPair = key + ":" + "[" + strValue +"]" + System.lineSeparator();
        		}
        	}else {
        		resultPair = key + ":" + "[" + values.get(i) +"]" + System.lineSeparator();
        	}
        	result += resultPair;
        	i++;
        }	
        return result;

	}
	
    public boolean SaveCache(String key, String value) {
    	String statusCode = "";
        try {
            statusCode = jedis.set(key, value);
        } catch (Exception ex) {
        	JOptionPane.showMessageDialog(null, "Connection Fail: "+ ex.getMessage());
        	return false;
        }
        return statusCode.equals("OK");

    }
    
    public long DeleteCache(String key) {
    	long result; 
        try {
            result = jedis.del(key);
        } catch (Exception ex) {
        	JOptionPane.showMessageDialog(null, "Connection Fail: "+ ex.getMessage());
        	return -1;
        }
        return result;
    }
	
	public String [] RetrieveServerInfo() {
		String info = jedis.info();
		String[] infos = info.split(System.lineSeparator());
		return infos;
	}
	
	public void Disconnect() {
		JOptionPane.showMessageDialog(null, "Disconnect");
		jedis.close();
	}

	public Object getCacheForObject(String key) {

	    Object responseContent = null;
	   
	    try {
	        byte[] value = jedis.get(key.getBytes());
	        responseContent = SerializeUtil. unserialize(value);
	    } catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, "Connection Fail: "+ e.getMessage());
	    } 

	    return responseContent;
	}
	
    public void addCacheForObject(String key, Object value) {

        try {
            jedis.set(key.getBytes(), SerializeUtil.serialize(value));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } 

    }
}
