package com.redis.cache.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.redis.cache.service.RedisService;

@Component
public class RedisHomeSearchPanel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	@Autowired RedisService redisService;
	
	private JTextField searchKeyValue;
	private JTextArea searchResponse;
	private JPanel titlePanel,contentPanel;
	private JScrollPane searchResponsePanel;
	
	public void InitRedisHomeSearchPanel() {
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
        JLabel titleLabel = new JLabel("Search Cache By Key");
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        titleLabel.setBounds(423, 13, 273, 93);
        titlePanel.add(titleLabel);
	}
	
	public void InitContentPanel() {
		
		contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBackground(Color.WHITE);
		
        //serch key
        JLabel keyLabel = new JLabel("Key");  
        keyLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        keyLabel.setBounds(250, 50, 193, 24);
        contentPanel.add(keyLabel);

        searchKeyValue = new JTextField();
        searchKeyValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
        searchKeyValue.setBounds(300, 50, 281, 24);
        searchKeyValue.setColumns(100);
        contentPanel.add(searchKeyValue);
        
        
        JButton searchBtn = new JButton("Search");
        searchBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        searchBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        searchBtn.setBounds(650, 50, 100, 24);
        searchBtn.addActionListener(this);
        contentPanel.add(searchBtn);
        
        
        JLabel resultLabel = new JLabel("Result:");  
        resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        resultLabel.setBounds(250, 150, 193, 24);
        contentPanel.add(resultLabel);
		
        InitSearchResponsePanel();
        searchResponsePanel.setBounds(250, 180, 500, 200);
        contentPanel.add(searchResponsePanel);
	}
	
	public void InitSearchResponsePanel() {
		searchResponsePanel = new JScrollPane();
		searchResponsePanel.setBorder(new LineBorder(Color.GRAY));
		searchResponsePanel.setLayout(new ScrollPaneLayout());
		searchResponsePanel.setAutoscrolls(true);
		searchResponse =new JTextArea();
		searchResponse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		searchResponse.setForeground(Color.BLUE);
		searchResponsePanel.setViewportView(searchResponse);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String key = searchKeyValue.getText();
		if(!key.isEmpty()) {
			String result = redisService.SearchValueByKey(key);
			searchResponse.setText(result);
		}else {
			searchResponse.setText("Key can not be empty");
		}
	}

}
