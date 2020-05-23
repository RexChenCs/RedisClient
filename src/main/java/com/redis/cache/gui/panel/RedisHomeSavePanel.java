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
public class RedisHomeSavePanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private JTextField saveKeyValue, saveBodyValue;
	private JLabel saveResponse;
	
	public void InitRedisHomeSavePanel() {

        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setLayout(null);
        JLabel titleLabel = new JLabel("Save Cache");
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        titleLabel.setBounds(423, 13, 273, 93);
        this.add(titleLabel);
        
        //save key
        JLabel keyLabel = new JLabel("Key");  
        keyLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        keyLabel.setBounds(250, 100, 193, 24);
        this.add(keyLabel);

        saveKeyValue = new JTextField();
        saveKeyValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
        saveKeyValue.setBounds(300, 100, 281, 24);
        saveKeyValue.setColumns(100);
        this.add(saveKeyValue);
        
        JLabel valueLabel = new JLabel("Value");  
        valueLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        valueLabel.setBounds(250, 140, 193, 24);
        this.add(valueLabel);

        saveBodyValue = new JTextField();
        saveBodyValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
        saveBodyValue.setBounds(300, 140, 281, 24);
        saveBodyValue.setColumns(100);
        this.add(saveBodyValue);
        
        
        JButton submit = new JButton("Save");
        submit.setFont(new Font("Tahoma", Font.PLAIN, 16));
        submit.setBorder(BorderFactory.createRaisedBevelBorder());
        submit.setBounds(650, 140, 100, 24);
        this.add(submit);
        
		
        saveResponse = new JLabel("Add Successful"); 
        saveResponse.setFont(new Font("Tahoma", Font.PLAIN, 16));
        saveResponse.setBounds(250, 230, 193, 24);
        saveResponse.setForeground(Color.BLUE);
        this.add(saveResponse);
        
	}
}
