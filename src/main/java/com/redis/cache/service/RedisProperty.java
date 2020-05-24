package com.redis.cache.service;

import org.springframework.stereotype.Component;

@Component
public class RedisProperty {
	
	private String host;
	private String port;
	private boolean isSslUsed;
	private String password;
	private String certPath;
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public boolean isSslUsed() {
		return isSslUsed;
	}
	public void setSslUsed(boolean isSslUsed) {
		this.isSslUsed = isSslUsed;
	}
	public String getCertPath() {
		return certPath;
	}
	public void setCertPath(String certPath) {
		this.certPath = certPath;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "RedisProperty [host=" + host + ", port=" + port + ", isSslUsed=" + isSslUsed + ", password=" + password
				+ ", certPath=" + certPath + "]";
	}
	
	

}
