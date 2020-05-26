package com.redis.cache.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;
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
			jedis = new Jedis(redisProperty.getHost(), Integer.parseInt(redisProperty.getPort()),
					redisProperty.isSslUsed());
			if (!redisProperty.getPassword().isEmpty()) {
				jedis.auth(redisProperty.getPassword());
			}
			if (redisProperty.isSslUsed()) {
				System.setProperty("javax.net.ssl.trustStoreType", redisProperty.getTrustStoreType());
				System.setProperty("javax.net.ssl.trustStore", redisProperty.getCertPath());
				System.setProperty("javax.net.ssl.trustStorePassword", redisProperty.getPassword());
			}
			Response = jedis.ping();
			System.out.println(Response);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Connection Fail: " + e.getMessage());
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

	public String[] SearchAllKey(String key) {
		Set<String> keys = jedis.keys(key);
		return keys.toArray(new String[keys.size()]);
	}

	public String SearchValueByKey(String searchKey) {
		String[] keys = SearchAllKey(searchKey);
		if (keys.length == 0) {
			return "Does not fidn the values of all the specified keys";
		}
		String result = "", resultPair = "",type="";
		for (String key : keys) {
			type = jedis.type(key);
			if (type.equals("hash")) {
				Map<String, String> map = jedis.hgetAll(key);
				resultPair = "Key: " +key + System.lineSeparator() 
								+ getTimeToLive(key) + System.lineSeparator() 
								+ "Value [" + System.lineSeparator()
								+ StringUtils.join(map,System.lineSeparator()) + System.lineSeparator()
								+ "]" + System.lineSeparator();
				
			} else if(type.equals("set")) {
				Set<String> set = jedis.smembers(key);
				resultPair = "Key: " +key + System.lineSeparator() 
								+ getTimeToLive(key) + System.lineSeparator() 
								+ "Value [" + System.lineSeparator()
								+ StringUtils.join(set,System.lineSeparator()) + System.lineSeparator()
								+ "]" + System.lineSeparator();
				
			} else if(type.equals("list")) {
				@SuppressWarnings("deprecation")
				List<String> list=jedis.brpop(key);
				resultPair ="Key: " + key + System.lineSeparator()
								+ getTimeToLive(key) + System.lineSeparator() 						 
								+ "Value [" + StringUtils.join(list,System.lineSeparator()) + System.lineSeparator()
								+ "]" + System.lineSeparator();
				
			}else if(type.equals("string")){
				String value = jedis.get(key);
				resultPair ="Key: " + key + System.lineSeparator() 
								+ getTimeToLive(key) + System.lineSeparator() 
								+ "Value [" + System.lineSeparator()
								+ value + System.lineSeparator()
								+ "]" + System.lineSeparator();
			}
			result += resultPair;
		}

		return result;

	}

	public boolean SaveCache(String key, String value) {
		String statusCode = "";
		try {
			statusCode = jedis.set(key, value);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Connection Fail: " + ex.getMessage());
			return false;
		}
		return statusCode.equals("OK");

	}

	public long DeleteCache(String key) {
		long result;
		try {
			result = jedis.del(key);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Connection Fail: " + ex.getMessage());
			return -1;
		}
		return result;
	}

	public String[] RetrieveServerInfo() {
		String info = jedis.info();
		String[] infos = info.split(System.lineSeparator());
		return infos;
	}

	public void Disconnect() {
		JOptionPane.showMessageDialog(null, "Disconnect");
		jedis.close();
	}


	public String getTimeToLive(String key) {
		String ttlResult ="Time To Live (Sec): ";
		long ttl = 0;
		try {
			ttl = jedis.ttl(key);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Retrieve TTL Fail: " + e.getMessage());
		}

		if(ttl == -2) {
			ttlResult+= "Key does not exists";
		}else if(ttl == -1) {
			ttlResult+= "Never expire";
		}else {
			ttlResult+= ttl;
		}
		return ttlResult;
	}
	
}
