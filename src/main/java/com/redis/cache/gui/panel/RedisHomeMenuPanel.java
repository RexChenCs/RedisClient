package com.redis.cache.gui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

import com.redis.cache.gui.RedisHomeFrame;
import com.redis.cache.gui.layoutProperty.MenuItemButton;
import com.redis.cache.gui.layoutProperty.MenuBarProperty;
import com.redis.cache.gui.layoutProperty.Panel;

@Component
public class RedisHomeMenuPanel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	private RedisHomeFrame homeFrame;
	
	public void InitRedisHomeMenuPanel(RedisHomeFrame homeFrame) {
		this.homeFrame = homeFrame;
		MenuBarProperty menuBarProperty = new MenuBarProperty();
		JButton viewAllButton, searchButton, deleteButton, addButton, ServerInfoButton, disconnectButton;
		viewAllButton = new JButton(MenuItemButton.VIEW_ALL.getValue());
		viewAllButton.setBackground(menuBarProperty.getMenuItemBg());
		viewAllButton.setForeground(menuBarProperty.getMenuItemFg());
		viewAllButton.setFont(menuBarProperty.getMenuItemFont());
		viewAllButton.addActionListener(this);
		
		searchButton = new JButton(MenuItemButton.SEARCH.getValue());
		searchButton.setBackground(menuBarProperty.getMenuItemBg());
		searchButton.setForeground(menuBarProperty.getMenuItemFg());
		searchButton.setFont(menuBarProperty.getMenuItemFont());
		searchButton.addActionListener(this);
		
		deleteButton = new JButton(MenuItemButton.DELETE.getValue());
		deleteButton.setBackground(menuBarProperty.getMenuItemBg());
		deleteButton.setForeground(menuBarProperty.getMenuItemFg());
		deleteButton.setFont(menuBarProperty.getMenuItemFont());
		deleteButton.addActionListener(this);
		
		addButton = new JButton(MenuItemButton.SAVE.getValue());
		addButton.setBackground(menuBarProperty.getMenuItemBg());
		addButton.setForeground(menuBarProperty.getMenuItemFg());
		addButton.setFont(menuBarProperty.getMenuItemFont());
		addButton.addActionListener(this);
		
		ServerInfoButton = new JButton(MenuItemButton.SERVER_INFO.getValue());
		ServerInfoButton.setBackground(menuBarProperty.getMenuItemBg());
		ServerInfoButton.setForeground(menuBarProperty.getMenuItemFg());
		ServerInfoButton.setFont(menuBarProperty.getMenuItemFont());
		ServerInfoButton.addActionListener(this);
		
		disconnectButton = new JButton(MenuItemButton.DISCONNECT.getValue());
		disconnectButton.setBackground(menuBarProperty.getMenuItemBg());
		disconnectButton.setForeground(menuBarProperty.getMenuItemFg());
		disconnectButton.setFont(menuBarProperty.getMenuItemFont());
		disconnectButton.addActionListener(this);
		this.add(viewAllButton);
		this.add(searchButton);
		this.add(addButton);
		this.add(deleteButton);
		this.add(ServerInfoButton);
		this.add(disconnectButton);
		this.setBackground(menuBarProperty.getMenuBg());
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals(MenuItemButton.DISCONNECT.getValue())) {
			this.homeFrame.SwitchPanel(Panel.LOGIN_PANEL);
		}else {
			switchContentPanel(ae.getActionCommand());
		}
	}
	
	public void switchContentPanel(String ac) {
		switch (ac) {
			case "View All":
				this.homeFrame.SwitchPanel(Panel.VIEW_PANEL);
				break;

			case "Search":
				this.homeFrame.SwitchPanel(Panel.SEARCH_PANEL);
				break;
				
			case "Save":
				this.homeFrame.SwitchPanel(Panel.SAVE_PANEL);
				break;
			case "Delete":
				this.homeFrame.SwitchPanel(Panel.DELETE_PANEL);
				break;
			case "Server Info":
				this.homeFrame.SwitchPanel(Panel.SERVER_INFO_PANEL);
				break;
			default:
				System.out.println("Midweek days are so-so.");
				break;
		}
		

	}
	

}
