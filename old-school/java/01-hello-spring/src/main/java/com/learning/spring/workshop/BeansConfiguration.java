package com.learning.spring.workshop;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public SimpleMessage simpleMessage() {
        SimpleMessage simpleMessage = new SimpleMessage();
        simpleMessage.setMessage("Hello Spring App with Java config");
        return simpleMessage;
    }
}