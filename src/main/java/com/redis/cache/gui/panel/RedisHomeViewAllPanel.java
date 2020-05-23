package com.redis.cache.gui.panel;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

@Component
public class RedisHomeViewAllPanel extends JScrollPane{

	private static final long serialVersionUID = 1L;
	
	public void InitRedisHomeViewAllPanel() {
		//JList<String> KeyList = new JList<String>();
	    this.setBorder(new EmptyBorder(15, 15, 15, 15));
        String keys[]= { "Monday","Tuesday","Wednesday", "Thursday","Friday","Saturday","Sunday"}; 
        JList<String> keyList= new JList<>();
        keyList.setListData(keys);
        keyList.setSelectedIndex(0);
        keyList.setBounds(0, 50, WIDTH, HEIGHT);
		this.getViewport().add(keyList);
	}

}
