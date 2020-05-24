package com.redis.cache.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.redis.cache.gui.layoutProperty.Panel;
import com.redis.cache.gui.panel.RedisHomeDeletePanel;
import com.redis.cache.gui.panel.RedisHomeMenuPanel;
import com.redis.cache.gui.panel.RedisHomeSavePanel;
import com.redis.cache.gui.panel.RedisHomeSearchPanel;
import com.redis.cache.gui.panel.RedisHomeServerInfoPanel;
import com.redis.cache.gui.panel.RedisHomeViewAllPanel;
import com.redis.cache.gui.panel.RedisLoginPanel;

@Component
public class RedisHomeFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RedisLoginPanel redisLoginPanel;
	
	@Autowired
	RedisHomeMenuPanel redisHomeMenuPanel;
	
	@Autowired
	private RedisHomeViewAllPanel redisHomeViewAllPanel;
	
	@Autowired
	private RedisHomeSearchPanel redisHomeSearchPanel;
	
	@Autowired
	private RedisHomeSavePanel redisHomeSavePanel;
	
	@Autowired
	private RedisHomeDeletePanel redisHomeDeletePanel;
	
	@Autowired
	private RedisHomeServerInfoPanel redisHomeServerInfoPanel;
	
	public void InitRedisHomeFrame() {
		this.setTitle("Redis Cache Client");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(450, 190, 1014, 597);
		this.setBackground(Color.WHITE);
		this.setResizable(false);
		redisLoginPanel.InitRedisLoginPanel(this);
		redisHomeViewAllPanel.InitRedisHomeViewAllPanel();
		redisHomeMenuPanel.InitRedisHomeMenuPanel(this);
		redisHomeSearchPanel.InitRedisHomeSearchPanel();
		redisHomeSavePanel.InitRedisHomeSavePanel();
		redisHomeDeletePanel.InitRedisHomeDeletePanel();
		redisHomeServerInfoPanel.InitRedisHomeServerInfoPanel();
		LoginUI();
	}

	public void LoginUI() {
		JPanel homePanel = new JPanel();
		homePanel.setLayout(new BorderLayout());
		homePanel.add(redisLoginPanel, BorderLayout.CENTER);
		this.setContentPane(homePanel);
	}

	public void HomeUI(JPanel panel) {
		JPanel homePanel = new JPanel();
		homePanel.setLayout(new BorderLayout());
		homePanel.add(redisHomeMenuPanel, BorderLayout.NORTH);
		homePanel.add(panel, BorderLayout.CENTER);
		this.setContentPane(homePanel);
	}
	
	public void SwitchPanel(Panel panel) {
		switch (panel) {
			case LOGIN_PANEL:
				LoginUI();
				break;
			case VIEW_PANEL:
				redisHomeViewAllPanel.UpdateViewAllKeyList();
				HomeUI(redisHomeViewAllPanel);
				break;
			case SEARCH_PANEL:
				HomeUI(redisHomeSearchPanel);
				break;
			case SAVE_PANEL:
				HomeUI(redisHomeSavePanel);
				break;
			case DELETE_PANEL:
				HomeUI(redisHomeDeletePanel);
				break;
			case SERVER_INFO_PANEL:
				redisHomeServerInfoPanel.UpdateServerInfoList();
				HomeUI(redisHomeServerInfoPanel);
				break;
			default:
				break;
		}
		SwingUtilities.updateComponentTreeUI(this);

	}

}
