package com.redis.cache.gui.panel;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

@Component
public class RedisHomeServerInfoPanel extends JScrollPane{

	private static final long serialVersionUID = 1L;
	
	private JList<String> serverInfoList;
	
	public void InitRedisHomeServerInfoPanel() {

	    this.setBorder(new EmptyBorder(15, 15, 15, 15));
        String keys[]= { "version","pool","config"}; 
        serverInfoList= new JList<>();
        serverInfoList.setListData(keys);
        serverInfoList.setSelectedIndex(0);
        serverInfoList.setBounds(0, 50, WIDTH, HEIGHT);
		this.getViewport().add(serverInfoList);
		
	}
}
