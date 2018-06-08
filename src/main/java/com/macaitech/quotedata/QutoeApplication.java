package com.macaitech.quotedata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@SpringBootApplication
public class QutoeApplication implements ApplicationListener<ContextRefreshedEvent> {

    public static void main(String[] args) {
        SpringApplication.run(QutoeApplication.class, args);
    }


    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
    	
    }
}
