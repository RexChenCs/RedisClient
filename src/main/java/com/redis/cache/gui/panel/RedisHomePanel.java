package com.redis.cache.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.redis.cache.gui.layoutProperty.Menu;
import com.redis.cache.gui.layoutProperty.MenuProperty;


public class RedisHomePanel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;

 
	//private RedisLoginGui loginGui;
	
	
	private MenuProperty menuProperty = new MenuProperty();

	
	private JFrame mainframe;
	private JPanel contentPanel, menuPanel,searchPanel, addPanel, deletePanel;
	private JScrollPane viewAllPanel,serverInfoPanel;
	
	public RedisHomePanel() {
		this.menuPanel = createMenuPanel();
		//this.viewAllPanel = createViewAllPanel();
		//this.searchPanel = createSearchPanel();
		//this.addPanel = createAddPanel();
		//this.deletePanel = createDeletePanel();
		//this.serverInfoPanel = createServerInfoPanel();
//		this.contentPanel = new JPanel();
		this.setLayout(new BorderLayout());
		this.add(this.menuPanel,BorderLayout.NORTH);	
		this.add(this.viewAllPanel,BorderLayout.CENTER);
//		this.mainframe.setContentPane(this.contentPanel);
//      this.mainframe.invalidate();
//      this.mainframe.validate();
	
	}
	
//	public void createRedisHome(JScrollPane scrollPane) {
//		this.contentPanel = new JPanel();
//		this.contentPanel.setLayout(new BorderLayout());
//		this.contentPanel.add(this.menuPanel,BorderLayout.NORTH);
//		this.contentPanel.add(scrollPane,BorderLayout.CENTER);
//		this.mainframe.setContentPane(this.contentPanel);
//        this.mainframe.invalidate();
//        this.mainframe.validate();
//	}

//	public void createRedisHome(JPanel panel) {
//		this.contentPanel = new JPanel();
//		this.contentPanel.setLayout(new BorderLayout());
//		this.contentPanel.add(this.menuPanel,BorderLayout.NORTH);
//		this.contentPanel.add(panel,BorderLayout.CENTER);
//		this.mainframe.setContentPane(this.contentPanel);
//        this.mainframe.invalidate();
//        this.mainframe.validate();
//	}
//	

	public JPanel createMenuPanel() {
		
		JButton viewAllButton, searchButton, deleteButton, addButton, ServerInfoButton, disconnectButton;
		viewAllButton = new JButton(Menu.VIEW_ALL.getValue());
		viewAllButton.setBackground(menuProperty.getMenuItemBg());
		viewAllButton.setForeground(menuProperty.getMenuItemFg());
		viewAllButton.setFont(menuProperty.getMenuItemFont());
		viewAllButton.addActionListener(this);
		
		searchButton = new JButton(Menu.SEARCH.getValue());
		searchButton.setBackground(menuProperty.getMenuItemBg());
		searchButton.setForeground(menuProperty.getMenuItemFg());
		searchButton.setFont(menuProperty.getMenuItemFont());
		searchButton.addActionListener(this);
		
		deleteButton = new JButton(Menu.DELETE.getValue());
		deleteButton.setBackground(menuProperty.getMenuItemBg());
		deleteButton.setForeground(menuProperty.getMenuItemFg());
		deleteButton.setFont(menuProperty.getMenuItemFont());
		deleteButton.addActionListener(this);
		
		addButton = new JButton(Menu.SAVE.getValue());
		addButton.setBackground(menuProperty.getMenuItemBg());
		addButton.setForeground(menuProperty.getMenuItemFg());
		addButton.setFont(menuProperty.getMenuItemFont());
		addButton.addActionListener(this);
		
		ServerInfoButton = new JButton(Menu.SERVER_INFO.getValue());
		ServerInfoButton.setBackground(menuProperty.getMenuItemBg());
		ServerInfoButton.setForeground(menuProperty.getMenuItemFg());
		ServerInfoButton.setFont(menuProperty.getMenuItemFont());
		ServerInfoButton.addActionListener(this);
		
		disconnectButton = new JButton(Menu.DISCONNECT.getValue());
		disconnectButton.setBackground(menuProperty.getMenuItemBg());
		disconnectButton.setForeground(menuProperty.getMenuItemFg());
		disconnectButton.setFont(menuProperty.getMenuItemFont());
		disconnectButton.addActionListener(this);
		
		JPanel menuPanel = new JPanel();
		menuPanel.add(viewAllButton);
		menuPanel.add(searchButton);
		menuPanel.add(addButton);
		menuPanel.add(deleteButton);
		menuPanel.add(ServerInfoButton);
		menuPanel.add(disconnectButton);
		menuPanel.setBackground(menuProperty.getMenuBg());
		return menuPanel;
		
	}
	
	private JList<String> keyList;
	
	public JScrollPane createViewAllPanel() {

		JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBorder(new EmptyBorder(15, 15, 15, 15));
        String keys[]= { "Monday","Tuesday","Wednesday", "Thursday","Friday","Saturday","Sunday"}; 
        keyList= new JList<>();
        keyList.setListData(keys);
        keyList.setSelectedIndex(0);
        keyList.setBounds(0, 50, WIDTH, HEIGHT);
		scrollPane.getViewport().add(keyList);
		
		return scrollPane;
	}
	
/*
	private JTextField searchKeyValue;
	private JLabel searchResponse;
	
	public JPanel createSearchPanel() {

		JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(null);
        JLabel titleLabel = new JLabel("Search Cache By Key");
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        titleLabel.setBounds(423, 13, 273, 93);
        panel.add(titleLabel);
        
        //host
        JLabel keyLabel = new JLabel("Key");  
        keyLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        keyLabel.setBounds(250, 100, 193, 24);
        panel.add(keyLabel);

        searchKeyValue = new JTextField();
        searchKeyValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
        searchKeyValue.setBounds(300, 100, 281, 24);
        searchKeyValue.setColumns(100);
        panel.add(searchKeyValue);
        
        
        JButton submit = new JButton("Search");
        submit.setFont(new Font("Tahoma", Font.PLAIN, 16));
        submit.setBorder(BorderFactory.createRaisedBevelBorder());
        submit.setBounds(650, 100, 100, 24);
        panel.add(submit);
        
        JLabel resultLabel = new JLabel("Result:");  
        resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        resultLabel.setBounds(250, 200, 193, 24);
        panel.add(resultLabel);
		
        searchResponse = new JLabel("Response test Text"); 
        searchResponse.setFont(new Font("Tahoma", Font.PLAIN, 16));
        searchResponse.setBounds(250, 230, 193, 24);
        searchResponse.setForeground(Color.BLUE);
        panel.add(searchResponse);
        
		return panel;
	}
	
	private JTextField addKeyValue, addBodyValue;
	private JLabel addResponse;
	
	public JPanel createAddPanel() {

		JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(null);
        JLabel titleLabel = new JLabel("Add Cache");
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        titleLabel.setBounds(423, 13, 273, 93);
        panel.add(titleLabel);
        
        //host
        JLabel keyLabel = new JLabel("Key");  
        keyLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        keyLabel.setBounds(250, 100, 193, 24);
        panel.add(keyLabel);

        addKeyValue = new JTextField();
        addKeyValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
        addKeyValue.setBounds(300, 100, 281, 24);
        addKeyValue.setColumns(100);
        panel.add(addKeyValue);
        
        JLabel valueLabel = new JLabel("Value");  
        valueLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        valueLabel.setBounds(250, 140, 193, 24);
        panel.add(valueLabel);

        addBodyValue = new JTextField();
        addBodyValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
        addBodyValue.setBounds(300, 140, 281, 24);
        addBodyValue.setColumns(100);
        panel.add(addBodyValue);
        
        
        JButton submit = new JButton("Save");
        submit.setFont(new Font("Tahoma", Font.PLAIN, 16));
        submit.setBorder(BorderFactory.createRaisedBevelBorder());
        submit.setBounds(650, 140, 100, 24);
        panel.add(submit);
        
		
        addResponse = new JLabel("Add Successful"); 
        addResponse.setFont(new Font("Tahoma", Font.PLAIN, 16));
        addResponse.setBounds(250, 230, 193, 24);
        addResponse.setForeground(Color.BLUE);
        panel.add(addResponse);
        
		return panel;
	}
	
	
	private JTextField deleteKeyValue;
	private JLabel deleteResponse;
	
	public JPanel createDeletePanel() {

		JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(null);
        JLabel titleLabel = new JLabel("Delete Cache By Key");
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        titleLabel.setBounds(423, 13, 273, 93);
        panel.add(titleLabel);
        
        //host
        JLabel keyLabel = new JLabel("Key");  
        keyLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        keyLabel.setBounds(250, 100, 193, 24);
        panel.add(keyLabel);

        deleteKeyValue = new JTextField();
        deleteKeyValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
        deleteKeyValue.setBounds(300, 100, 281, 24);
        deleteKeyValue.setColumns(100);
        panel.add(deleteKeyValue);
        
        JButton submit = new JButton("Delete");
        submit.setFont(new Font("Tahoma", Font.PLAIN, 16));
        submit.setBorder(BorderFactory.createRaisedBevelBorder());
        submit.setBounds(650, 100, 100, 24);
        panel.add(submit);
        
		
        deleteResponse = new JLabel("Delete Succefully"); 
        deleteResponse.setFont(new Font("Tahoma", Font.PLAIN, 16));
        deleteResponse.setBounds(250, 230, 193, 24);
        deleteResponse.setForeground(Color.BLUE);
        panel.add(deleteResponse);
        
		return panel;
	}
	
	private JList<String> serverInfoList;
	
	public JScrollPane createServerInfoPanel() {

		JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBorder(new EmptyBorder(15, 15, 15, 15));
        String keys[]= { "version","pool","config"}; 
        serverInfoList= new JList<>();
        serverInfoList.setListData(keys);
        serverInfoList.setSelectedIndex(0);
        serverInfoList.setBounds(0, 50, WIDTH, HEIGHT);
		scrollPane.getViewport().add(serverInfoList);
		
		return scrollPane;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals(Menu.DISCONNECT.getValue())) {
//			this.mainframe.setContentPane(loginGui.CreateRedisLoginGui());
	        this.mainframe.invalidate();
	        this.mainframe.validate();
		}else {
			switchContentPanel(ae.getActionCommand());
		}
	}
	
	public void switchContentPanel(String actionCommand) {
		
		if(actionCommand.equals(Menu.VIEW_ALL.getValue())) {
			String keys[]= { "Test"}; 
			this.keyList.setListData(keys);
			createRedisHome(this.viewAllPanel);
		}
		
		if(actionCommand.equals(Menu.SEARCH.getValue())) {
			createRedisHome(this.searchPanel);
		}
		
		if(actionCommand.equals(Menu.ADD.getValue())) {
			createRedisHome(this.addPanel);
		}
		
		if(actionCommand.equals(Menu.DELETE.getValue())) {
			createRedisHome(this.deletePanel);
		}
		
		if(actionCommand.equals(Menu.SERVER_INFO.getValue())) {
			createRedisHome(this.serverInfoPanel);
		}
	}
	*/

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
