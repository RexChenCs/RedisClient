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
public class RedisHomeSavePanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	private JTextField saveKeyValue, saveBodyValue,saveTtlValue;
	private JPanel titlePanel = new JPanel(),contentPanel = new JPanel();
	private JScrollPane saveResponsePanel = new JScrollPane();
	private JTextArea saveResponse;
	
	@Autowired
	private RedisService redisService;
	
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
        JLabel titleLabel = new JLabel("Save Cache");
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

        saveKeyValue = new JTextField();
        saveKeyValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
        saveKeyValue.setBounds(300, 50, 281, 24);
        saveKeyValue.setColumns(100);
        contentPanel.add(saveKeyValue);
        
        JLabel valueLabel = new JLabel("Value");  
        valueLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        valueLabel.setBounds(250, 85, 193, 24);
        contentPanel.add(valueLabel);

        saveBodyValue = new JTextField();
        saveBodyValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
        saveBodyValue.setBounds(300, 85, 281, 24);
        saveBodyValue.setColumns(100);
        contentPanel.add(saveBodyValue);  
        
        JLabel ttlLabel = new JLabel("TTL");  
        ttlLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ttlLabel.setBounds(250, 120, 193, 24);
        contentPanel.add(ttlLabel);

        saveTtlValue = new JTextField();
        saveTtlValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
        saveTtlValue.setBounds(300, 120, 281, 24);
        saveTtlValue.setColumns(100);
        contentPanel.add(saveTtlValue);
        
        JButton saveBtn = new JButton("Save");
        saveBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        saveBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        saveBtn.setBounds(650, 130, 100, 24);
        saveBtn.addActionListener(this);
        contentPanel.add(saveBtn);
        
        JLabel resultLabel = new JLabel("Result:");  
        resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        resultLabel.setBounds(250, 150, 193, 24);
        contentPanel.add(resultLabel);
		
        InitSaveResponsePanel();
        saveResponsePanel.setBounds(250, 180, 500, 200);
        contentPanel.add(saveResponsePanel);
	}
	
	public void InitSaveResponsePanel() {
		saveResponsePanel.setBorder(new LineBorder(Color.GRAY));
		saveResponsePanel.setLayout(new ScrollPaneLayout());
		saveResponsePanel.setAutoscrolls(true);
		saveResponse =new JTextArea();
		saveResponse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		saveResponse.setForeground(Color.BLUE);
		saveResponsePanel.setViewportView(saveResponse);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String key  = saveKeyValue.getText();
		String value = saveBodyValue.getText();
		String ttl = saveTtlValue.getText();
		if(key.isEmpty() || value.isEmpty()) {
			saveResponse.setText("Key or Value can not be empty");
		}else {
			boolean isSaved = redisService.SaveCache(key, value, ttl);
			saveResponse.setText(isSaved?"Save Successfully":"Fail to Save");
		}
	}
}
