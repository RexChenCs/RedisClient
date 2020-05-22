package com.redis.cache;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.redis.cache.gui.InitUI;

@SpringBootApplication
public class RedisCacheGuiApplication extends JFrame{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		ApplicationContext ctx = new SpringApplicationBuilder(RedisCacheGuiApplication.class)
                .headless(false).run(args);
        EventQueue.invokeLater(() -> {
        	InitUI ex = ctx.getBean(InitUI.class);
        	ex.initUI();
        });
		
	}

}
