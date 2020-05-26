package com.redis.cache.gui.layoutProperty;

public enum LoginItemButton {
	
	SELECT_FILE("Select File"), 
	OPEN_PROFILE("Open Profile"), 
	SAVE_PROFILE("Save Profile"), 
    CONNECT("Connect");

	private String value;
	
	LoginItemButton(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
