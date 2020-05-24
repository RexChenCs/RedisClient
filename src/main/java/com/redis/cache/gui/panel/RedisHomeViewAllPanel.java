package com.redis.cache.gui.panel;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

@Component
public class RedisHomeViewAllPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JPanel titlePanel;
	private JScrollPane contentPanel;
	private JList<String> keyList = new JList<>();
	
	public void InitRedisHomeViewAllPanel() {
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
        JLabel titleLabel = new JLabel("View All Cache Key");
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        titleLabel.setBounds(423, 13, 273, 93);
        titlePanel.add(titleLabel);
	}
	
	public void InitContentPanel() {
		contentPanel = new JScrollPane();
		contentPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        keyList.setBounds(0, 50, WIDTH, HEIGHT);
        contentPanel.getViewport().add(keyList);
	}
	
	public void UpdateViewAllKeyList() {
		String keys[]= { "Monday","Tuesday","Wednesday", "Thursday","Friday","Saturday","Sunday"}; 
		keyList.setListData(keys);
		keyList.setSelectedIndex(0);
	}
}
