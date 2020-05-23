package com.redis.cache.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

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

import org.springframework.stereotype.Component;

@Component
public class RedisHomeSavePanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private JTextField saveKeyValue, saveBodyValue;
	private JPanel titlePanel,contentPanel;
	private JScrollPane saveResponsePanel;
	private JTextArea saveResponse;
	
	public void InitRedisHomeSavePanel() {

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
        JLabel titleLabel = new JLabel("Save Cache");
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        titleLabel.setBounds(423, 13, 273, 93);
        titlePanel.add(titleLabel);
	}
	
	public void InitContentPanel() {
		
		contentPanel = new JPanel();
		contentPanel.setLayout(null);
		
        //save key
        JLabel keyLabel = new JLabel("Key");  
        keyLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        keyLabel.setBounds(250, 50, 193, 24);
        contentPanel.add(keyLabel);

        saveKeyValue = new JTextField();
        saveKeyValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
        saveKeyValue.setBounds(300, 50, 281, 24);
        saveKeyValue.setColumns(100);
        contentPanel.add(saveKeyValue);
        
        JLabel valueLabel = new JLabel("Value");  
        valueLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        valueLabel.setBounds(250, 90, 193, 24);
        contentPanel.add(valueLabel);

        saveBodyValue = new JTextField();
        saveBodyValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
        saveBodyValue.setBounds(300, 90, 281, 24);
        saveBodyValue.setColumns(100);
        contentPanel.add(saveBodyValue);
        
        
        JButton submit = new JButton("Save");
        submit.setFont(new Font("Tahoma", Font.PLAIN, 16));
        submit.setBorder(BorderFactory.createRaisedBevelBorder());
        submit.setBounds(650, 90, 100, 24);
        contentPanel.add(submit);
        
        
        JLabel resultLabel = new JLabel("Result:");  
        resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        resultLabel.setBounds(250, 150, 193, 24);
        contentPanel.add(resultLabel);
		
        InitSaveResponsePanel();
        saveResponsePanel.setBounds(250, 180, 500, 200);
        contentPanel.add(saveResponsePanel);
	}
	
	public void InitSaveResponsePanel() {
		saveResponsePanel = new JScrollPane();
		saveResponsePanel.setBorder(new LineBorder(Color.GRAY));
		saveResponsePanel.setLayout(new ScrollPaneLayout());
		saveResponsePanel.setAutoscrolls(true);
		saveResponse =new JTextArea("Response test Text ");
		saveResponse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		saveResponse.setForeground(Color.BLUE);
		saveResponsePanel.setViewportView(saveResponse);


	}
}
