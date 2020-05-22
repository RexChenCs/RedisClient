package com.redis.cache.gui;

import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
		
	@Autowired RedisLoginGui redisLoginGui;

	public void initUI() {
		redisLoginGui.CreateRedisLoginGui();
    }
    
}
