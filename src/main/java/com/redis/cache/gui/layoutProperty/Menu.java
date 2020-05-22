package com.redis.cache.gui.layoutProperty;

public enum Menu {
	
	VIEW_ALL("View all"), 
	SEARCH("Search"), 
	ADD("Add"), 
	DELETE("Delete"), 
	SERVER_INFO("Server Info"), 
	DISCONNECT("Disconnect");

	private String value;
	
	Menu(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
