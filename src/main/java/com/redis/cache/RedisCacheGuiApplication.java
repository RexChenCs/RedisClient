package com.redis.cache;

import java.awt.EventQueue;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.redis.cache.gui.RedisHomeFrame;

@SpringBootApplication
public class RedisCacheGuiApplication{

	public static void main(String[] args) {

		ApplicationContext ctx = new SpringApplicationBuilder(RedisCacheGuiApplication.class)
                .headless(false).run(args);
        EventQueue.invokeLater(() -> {
        	RedisHomeFrame ex = ctx.getBean(RedisHomeFrame.class);
        	ex.InitRedisHomeFrame();
        	ex.setVisible(true);
        });
		
	}
	
}
