package com.redis.cache.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.redis.cache.util.RedisUtil;

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
			JOptionPane.showMessageDialog(null, "Fail to Connect server: " + e.getMessage());
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
		String result = "", resultPair = "", type = "";
		try {
			String[] keys = SearchAllKey(searchKey);
			if (keys.length == 0) {
				return "Does not find the values of all the specified keys";
			}
			for (String key : keys) {
				type = jedis.type(key);
				if (type.equals("hash")) {
					Map<String, String> map = jedis.hgetAll(key);
					resultPair = "Key: " + key + System.lineSeparator() + getTimeToLive(key) + System.lineSeparator()
							+ "Value: " + System.lineSeparator() + RedisUtil.ConvertMapToString(map);

				} else if (type.equals("set")) {
					Set<String> set = jedis.smembers(key);
					resultPair = "Key: " + key + System.lineSeparator() + getTimeToLive(key) + System.lineSeparator()
							+ "Value: " + System.lineSeparator() + RedisUtil.ConvertSetToString(set);

				} else if (type.equals("list")) {
					@SuppressWarnings("deprecation")
					List<String> list = jedis.brpop(key);
					resultPair = "Key: " + key + System.lineSeparator() + getTimeToLive(key) + System.lineSeparator()
							+ "Value: " + System.lineSeparator() + RedisUtil.ConvertListToString(list);

				} else if (type.equals("string")) {
					String value = jedis.get(key);
					resultPair = "Key: " + key + System.lineSeparator() + getTimeToLive(key) + System.lineSeparator()
							+ "Value: " + value + System.lineSeparator();
				}
				result += resultPair;
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Fail to search: " + ex.getMessage());
		}

		return result;

	}

	public boolean SaveCache(String key, String value, String strTtl) {
		String statusCode = "";
		try {
			int ttl = strTtl.trim().isEmpty() ? -1 : Integer.parseInt(strTtl.trim());
			if (ttl > 0) {
				statusCode = jedis.setex(key, ttl, value);
			} else {
				statusCode = jedis.set(key, value);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Fail to save: " + ex.getMessage());
			return false;
		}
		return statusCode.equals("OK");

	}

	public long DeleteCache(String key) {
		long result;
		try {
			result = jedis.del(key);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Fail to delete: " + ex.getMessage());
			return -1;
		}
		return result;
	}

	public String[] RetrieveServerInfo() {
		String info;
		String[] infos = null;
		try {
			info = jedis.info();
			infos = info.split(System.lineSeparator());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Fail to retrieve server info: " + ex.getMessage());
		}
		return infos;
	}

	public void Disconnect() {
		try {
			JOptionPane.showMessageDialog(null, "Disconnect");
			jedis.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Fail to disconnect: " + ex.getMessage());
		}
	}

	public String getTimeToLive(String key) {
		String ttlResult = "Time To Live (Sec): ";
		long ttl = 0;
		try {
			ttl = jedis.ttl(key);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Retrieve TTL Fail: " + e.getMessage());
		}

		if (ttl == -2) {
			ttlResult += "Key does not exists";
		} else if (ttl == -1) {
			ttlResult += "Never expire";
		} else {
			ttlResult += ttl;
		}
		return ttlResult;
	}

}
