package com.redis.cache.gui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

import com.redis.cache.gui.RedisHomeFrame;
import com.redis.cache.gui.layoutProperty.Menu;
import com.redis.cache.gui.layoutProperty.MenuProperty;
import com.redis.cache.gui.layoutProperty.Panel;

@Component
public class RedisHomeMenuPanel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	private RedisHomeFrame homeFrame;
	
	public void InitRedisHomeMenuPanel(RedisHomeFrame homeFrame) {
		this.homeFrame = homeFrame;
		MenuProperty menuProperty = new MenuProperty();
		JButton viewAllButton, searchButton, deleteButton, addButton, ServerInfoButton, disconnectButton;
		viewAllButton = new JButton(Menu.VIEW_ALL.getValue());
		viewAllButton.setBackground(menuProperty.getMenuItemBg());
		viewAllButton.setForeground(menuProperty.getMenuItemFg());
		viewAllButton.setFont(menuProperty.getMenuItemFont());
		viewAllButton.addActionListener(this);
		
		searchButton = new JButton(Menu.SEARCH.getValue());
		searchButton.setBackground(menuProperty.getMenuItemBg());
		searchButton.setForeground(menuProperty.getMenuItemFg());
		searchButton.setFont(menuProperty.getMenuItemFont());
		searchButton.addActionListener(this);
		
		deleteButton = new JButton(Menu.DELETE.getValue());
		deleteButton.setBackground(menuProperty.getMenuItemBg());
		deleteButton.setForeground(menuProperty.getMenuItemFg());
		deleteButton.setFont(menuProperty.getMenuItemFont());
		deleteButton.addActionListener(this);
		
		addButton = new JButton(Menu.SAVE.getValue());
		addButton.setBackground(menuProperty.getMenuItemBg());
		addButton.setForeground(menuProperty.getMenuItemFg());
		addButton.setFont(menuProperty.getMenuItemFont());
		addButton.addActionListener(this);
		
		ServerInfoButton = new JButton(Menu.SERVER_INFO.getValue());
		ServerInfoButton.setBackground(menuProperty.getMenuItemBg());
		ServerInfoButton.setForeground(menuProperty.getMenuItemFg());
		ServerInfoButton.setFont(menuProperty.getMenuItemFont());
		ServerInfoButton.addActionListener(this);
		
		disconnectButton = new JButton(Menu.DISCONNECT.getValue());
		disconnectButton.setBackground(menuProperty.getMenuItemBg());
		disconnectButton.setForeground(menuProperty.getMenuItemFg());
		disconnectButton.setFont(menuProperty.getMenuItemFont());
		disconnectButton.addActionListener(this);
		this.add(viewAllButton);
		this.add(searchButton);
		this.add(addButton);
		this.add(deleteButton);
		this.add(ServerInfoButton);
		this.add(disconnectButton);
		this.setBackground(menuProperty.getMenuBg());
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals(Menu.DISCONNECT.getValue())) {
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
