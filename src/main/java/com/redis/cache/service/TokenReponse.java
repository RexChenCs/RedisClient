package com.redis.cache.service;

import java.io.Serializable;

public class TokenReponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private int time;
	private String token;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	

}
