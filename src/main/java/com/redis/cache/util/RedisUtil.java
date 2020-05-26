package com.redis.cache.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class RedisUtil {
	
	public static String ConvertMapToString(Map<String, String> map) {
		
		String result = "{"+System.lineSeparator();
		for(Map.Entry<String,String> entry: map.entrySet()) {
			String row = "\t" + entry.getKey() + " : " + entry.getValue() +System.lineSeparator();
			result += row;
		}
		
		result += "}"+System.lineSeparator();
		return result;
	}
	
	public static String ConvertSetToString(Set<String> set) {
		
		String result = "{"+System.lineSeparator();
		for(String element: set) {
			String row = "\t" + element +System.lineSeparator();
			result += row;
		}

		result += "}"+System.lineSeparator();
		return result;
	}
	
	public static String ConvertListToString(List<String> list) {
		
		String result = "{"+System.lineSeparator();
		for(String element: list) {
			String row = "\t" + element +System.lineSeparator();
			result += row;
		}

		result += "}"+System.lineSeparator();
		return result;
	}

}
