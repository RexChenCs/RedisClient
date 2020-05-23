package com.redis.cache.gui.layoutProperty;

public enum MenuItemButton {
	
	VIEW_ALL("View All"), 
	SEARCH("Search"), 
	SAVE("Save"), 
	DELETE("Delete"), 
	SERVER_INFO("Server Info"), 
	DISCONNECT("Disconnect");

	private String value;
	
	MenuItemButton(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
