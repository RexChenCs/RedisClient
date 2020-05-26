package com.redis.cache.service;

import org.springframework.stereotype.Component;

@Component
public class RedisProperty {
	
	private String host;
	private String port = "6379";
	private boolean isSslUsed;
	private String password;
	private String certPath;
	private String trustStoreType = "jks";
	private String trustStorePassword = "changeit";

    
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
		if(!port.isEmpty()) {
			this.port = port;
		}
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
		if(!certPath.isEmpty()) {
			findTrustStoreType();
		}
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTrustStoreType() {
		return trustStoreType;
	}
	public void setTrustStoreType(String trustStoreType) {
		this.trustStoreType = trustStoreType;
	}
	
	private void findTrustStoreType() {
		int index = this.certPath.lastIndexOf(".");
		if(index > -1) {
			this.trustStoreType = this.certPath.substring(index);
		}
	}
	public String getTrustStorePassword() {
		return trustStorePassword;
	}
	public void setTrustStorePassword(String trustStorePassword) {
		this.trustStorePassword = trustStorePassword;
	}
	@Override
	public String toString() {
		return "RedisProperty [host=" + host + ", port=" + port + ", isSslUsed=" + isSslUsed + ", password=" + password
				+ ", certPath=" + certPath + ", trustStoreType=" + trustStoreType + ", trustStorePassword="
				+ trustStorePassword + "]";
	}	

}
