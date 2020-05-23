package com.redis.cache.gui.panel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

@Component
public class RedisHomeSearchPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;

	private JTextField searchKeyValue;
	private JLabel searchResponse;
	
	//private RedisHomeFrame homeFrame;
	
	public void InitRedisHomeSearchPanel() {
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setLayout(null);
        JLabel titleLabel = new JLabel("Search Cache By Key");
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        titleLabel.setBounds(423, 13, 273, 93);
        this.add(titleLabel);
        
        //serch key
        JLabel keyLabel = new JLabel("Key");  
        keyLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        keyLabel.setBounds(250, 100, 193, 24);
        this.add(keyLabel);

        searchKeyValue = new JTextField();
        searchKeyValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
        searchKeyValue.setBounds(300, 100, 281, 24);
        searchKeyValue.setColumns(100);
        this.add(searchKeyValue);
        
        
        JButton submit = new JButton("Search");
        submit.setFont(new Font("Tahoma", Font.PLAIN, 16));
        submit.setBorder(BorderFactory.createRaisedBevelBorder());
        submit.setBounds(650, 100, 100, 24);
        this.add(submit);
        
        JLabel resultLabel = new JLabel("Result:");  
        resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        resultLabel.setBounds(250, 200, 193, 24);
        this.add(resultLabel);
		
        searchResponse = new JLabel("Response test Text"); 
        searchResponse.setFont(new Font("Tahoma", Font.PLAIN, 16));
        searchResponse.setBounds(250, 230, 193, 24);
        searchResponse.setForeground(Color.BLUE);
        this.add(searchResponse);
		
	}

}
