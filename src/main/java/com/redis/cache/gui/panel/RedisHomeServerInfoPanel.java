package com.redis.cache.gui.panel;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.redis.cache.service.RedisService;

@Component
public class RedisHomeServerInfoPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	@Autowired 
	private RedisService redisService;
	
	private JList<String> serverInfoList = new JList<>();
	private JPanel titlePanel;
	private JScrollPane contentPanel;
	
	public void InitRedisHomeServerInfoPanel() {
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setLayout(null);
        this.setLayout(new BorderLayout());
        InitTitlePanel();
		this.add(titlePanel, BorderLayout.NORTH);
		InitContentPanel();
		this.add(contentPanel, BorderLayout.CENTER);
	}

	public void InitTitlePanel() {
		titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Server Info");
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        titleLabel.setBounds(423, 13, 273, 93);
        titlePanel.add(titleLabel);
	}
	
	public void InitContentPanel() {
		contentPanel = new JScrollPane();
		contentPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
		serverInfoList.setBounds(0, 50, WIDTH, HEIGHT);
        contentPanel.getViewport().add(serverInfoList);
	}
	
	public void UpdateServerInfoList() {
		String keys[]= redisService.RetrieveServerInfo(); 
		serverInfoList.setListData(keys);
		serverInfoList.setSelectedIndex(0);
	}
}
