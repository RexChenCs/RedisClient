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
public class RedisHomeDeletePanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private JTextField deleteKeyValue;
	private JLabel deleteResponse;
	
	public void InitRedisHomeDeletePanel() {

        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setLayout(null);
        JLabel titleLabel = new JLabel("Delete Cache By Key");
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        titleLabel.setBounds(423, 13, 273, 93);
        this.add(titleLabel);
        
        //delete key
        JLabel keyLabel = new JLabel("Key");  
        keyLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        keyLabel.setBounds(250, 100, 193, 24);
        this.add(keyLabel);

        deleteKeyValue = new JTextField();
        deleteKeyValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
        deleteKeyValue.setBounds(300, 100, 281, 24);
        deleteKeyValue.setColumns(100);
        this.add(deleteKeyValue);
        
        JButton submit = new JButton("Delete");
        submit.setFont(new Font("Tahoma", Font.PLAIN, 16));
        submit.setBorder(BorderFactory.createRaisedBevelBorder());
        submit.setBounds(650, 100, 100, 24);
        this.add(submit);
        
		
        deleteResponse = new JLabel("Delete Succefully"); 
        deleteResponse.setFont(new Font("Tahoma", Font.PLAIN, 16));
        deleteResponse.setBounds(250, 230, 193, 24);
        deleteResponse.setForeground(Color.BLUE);
        this.add(deleteResponse);

	}
	
}
