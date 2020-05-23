package com.redis.cache.gui.layoutProperty;

public enum Panel {

	LOGIN_PANEL("LOGIN_PANEL"), 
	VIEW_PANEL("VIEW_PANEL"),
	SEARCH_PANEL("Search"), 
	SAVE_PANEL("Add"), 
	DELETE_PANEL("Delete"), 
	SERVER_INFO_PANEL("Server Info"),;

	private String value;
	
	Panel(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
