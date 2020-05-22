package com.redis.cache.gui.layoutProperty;

import java.awt.Color;
import java.awt.Font;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class MenuProperty {
	
	private Color menuItemBg = new Color(153,204,255);
	private Color menuItemFg = Color.BLACK;
	private Font menuItemFont = new Font("Tahoma", Font.PLAIN, 14);
	private Color menuBg = new Color(255,128,0);
	
	public Color getMenuItemBg() {
		return menuItemBg;
	}
	public void setMenuItemBg(Color menuItemBg) {
		this.menuItemBg = menuItemBg;
	}
	public Font getMenuItemFont() {
		return menuItemFont;
	}
	public void setMenuItemFont(Font menuItemFont) {
		this.menuItemFont = menuItemFont;
	}
	public Color getMenuItemFg() {
		return menuItemFg;
	}
	public void setMenuItemFg(Color menuItemFg) {
		this.menuItemFg = menuItemFg;
	}
	public Color getMenuBg() {
		return menuBg;
	}
	public void setMenuBg(Color menuBg) {
		this.menuBg = menuBg;
	}
	 

}
