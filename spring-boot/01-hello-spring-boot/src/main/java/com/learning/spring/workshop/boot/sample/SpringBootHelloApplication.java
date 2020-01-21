package com.learning.spring.workshop.boot.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringBootHelloApplication {

    @Autowired
    private SimpleMessage simpleMessage;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloApplication.class, args);
    }

    @PostConstruct
    public void afterPropertiesSet() {
        System.out.println("Your Message : " + this.simpleMessage.getMessage());
    }

    @Bean
    public SimpleMessage simpleMessage() {
        SimpleMessage simpleMessage = new SimpleMessage();
        simpleMessage.setMessage("Hello Spring Boot");
        return simpleMessage;
    }

}
