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
public class RedisHomeDeletePanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	private JPanel titlePanel = new JPanel();
	private JPanel contentPanel = new JPanel();
	private JScrollPane deleteResponsePanel = new JScrollPane();
	private JTextField deleteKeyValue;
	private JTextArea deleteResponse;
	
	@Autowired
	private RedisService redisService;
	
	public void InitRedisHomeDeletePanel() {
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setLayout(null);
        this.setLayout(new BorderLayout());
        InitTitlePanel();
		this.add(titlePanel, BorderLayout.NORTH);
		InitContentPanel();
		this.add(contentPanel, BorderLayout.CENTER);
	}
	
	
	public void InitTitlePanel() {
        JLabel titleLabel = new JLabel("Delete Cache");
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        titleLabel.setBounds(423, 13, 273, 93);
        titlePanel.add(titleLabel);
	}
	
	public void InitContentPanel() {

		contentPanel.setLayout(null);
		contentPanel.setBackground(Color.WHITE);
		
        //save key
        JLabel keyLabel = new JLabel("Key");  
        keyLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        keyLabel.setBounds(250, 50, 193, 24);
        contentPanel.add(keyLabel);

        deleteKeyValue = new JTextField();
        deleteKeyValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
        deleteKeyValue.setBounds(300, 50, 281, 24);
        deleteKeyValue.setColumns(100);
        contentPanel.add(deleteKeyValue);
        
        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        deleteBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        deleteBtn.setBounds(650, 50, 100, 24);
        deleteBtn.addActionListener(this);
        contentPanel.add(deleteBtn);
        
        JLabel resultLabel = new JLabel("Result:");  
        resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        resultLabel.setBounds(250, 150, 193, 24);
        contentPanel.add(resultLabel);
		
        InitDeleteResponsePanel();
        deleteResponsePanel.setBounds(250, 180, 500, 200);
        contentPanel.add(deleteResponsePanel);
	}
	
	public void InitDeleteResponsePanel() {
		deleteResponsePanel.setBorder(new LineBorder(Color.GRAY));
		deleteResponsePanel.setLayout(new ScrollPaneLayout());
		deleteResponsePanel.setAutoscrolls(true);
		deleteResponse =new JTextArea();
		deleteResponse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deleteResponse.setForeground(Color.BLUE);
		deleteResponsePanel.setViewportView(deleteResponse);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String key = deleteKeyValue.getText();
		long numOfCacheDeleted = redisService.DeleteCache(key);
		
		if(numOfCacheDeleted == -1) {
			deleteResponse.setText("Fail to Delete");
		}else if(numOfCacheDeleted == 0) {
			deleteResponse.setText("None of the specified key existed: "+key);
		}else {
			deleteResponse.setText(numOfCacheDeleted+" keys were removed");
		}
	}
}
