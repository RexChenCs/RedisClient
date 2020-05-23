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
public class RedisHomeSearchPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;

	private JTextField searchKeyValue;
	private JTextArea searchResponse;
	//private RedisHomeFrame homeFrame;
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
		//contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		
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
        
        
        JButton submit = new JButton("Search");
        submit.setFont(new Font("Tahoma", Font.PLAIN, 16));
        submit.setBorder(BorderFactory.createRaisedBevelBorder());
        submit.setBounds(650, 50, 100, 24);
        contentPanel.add(submit);
        
        
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
		searchResponse =new JTextArea("Response test Text " +
//				"2020-05-23 15:22:17.905  INFO 41054 --- [  restartedMain] c.redis.cache.RedisCacheGuiApplication   : Starting RedisCacheGuiApplication on QIXIANGs-MacBook-Pro.local with PID 41054 (/Users/Rex/Desktop/Redis/RedisClient/target/classes started by Admin in /Users/Rex/Desktop/Redis/RedisClient)\n" + 
//				"2020-05-23 15:22:17.906  INFO 41054 --- [  restartedMain] c.redis.cache.RedisCacheGuiApplication   : No active profile set, falling back to default profiles: default\n" + 
//				"2020-05-23 15:22:18.016  INFO 41054 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode!\n" + 
//				"2020-05-23 15:22:18.016  INFO 41054 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data Redis repositories in DEFAULT mode.\n" + 
//				"2020-05-23 15:22:18.027  INFO 41054 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 11ms. Found 0 Redis repository interfaces.\n" + 
//				"2020-05-23 15:22:18.140  INFO 41054 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729\n" + 
//				"2020-05-23 15:22:18.161  INFO 41054 --- [  restartedMain] c.redis.cache.RedisCacheGuiApplication   : Started RedisCacheGuiApplication in 0.277 seconds (JVM running for 388.764)\n" + 
//				"2020-05-23 15:22:18.162  INFO 41054 --- [  restartedMain] .ConditionEvaluationDeltaLoggingListener : Condition evaluation unchanged\n" + 
//				"2020-05-23 15:22:18.140  INFO 41054 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729\n" + 
//				"2020-05-23 15:22:18.161  INFO 41054 --- [  restartedMain] c.redis.cache.RedisCacheGuiApplication   : Started RedisCacheGuiApplication in 0.277 seconds (JVM running for 388.764)\n" + 
//				"2020-05-23 15:22:18.162  INFO 41054 --- [  restartedMain] .ConditionEvaluationDeltaLoggingListener : Condition evaluation unchanged\n" + 
//				"2020-05-23 15:22:18.140  INFO 41054 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729\n" + 
//				"2020-05-23 15:22:18.161  INFO 41054 --- [  restartedMain] c.redis.cache.RedisCacheGuiApplication   : Started RedisCacheGuiApplication in 0.277 seconds (JVM running for 388.764)\n" + 
//				"2020-05-23 15:22:18.162  INFO 41054 --- [  restartedMain] .ConditionEvaluationDeltaLoggingListener : Condition evaluation unchanged\n" + 
//				"2020-05-23 15:22:18.140  INFO 41054 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729\n" + 
//				"2020-05-23 15:22:18.161  INFO 41054 --- [  restartedMain] c.redis.cache.RedisCacheGuiApplication   : Started RedisCacheGuiApplication in 0.277 seconds (JVM running for 388.764)\n" + 
//				"2020-05-23 15:22:18.162  INFO 41054 --- [  restartedMain] .ConditionEvaluationDeltaLoggingListener : Condition evaluation unchanged\n" + 
				"");
		searchResponse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		searchResponse.setForeground(Color.BLUE);
		searchResponsePanel.setViewportView(searchResponse);
		//searchResponsePanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		//searchResponsePanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  

	}

}
