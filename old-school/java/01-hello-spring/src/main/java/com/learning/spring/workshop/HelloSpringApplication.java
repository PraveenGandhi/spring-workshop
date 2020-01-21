package com.learning.spring.workshop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloSpringApplication {

    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfiguration.class);
        SimpleMessage simpleMessage = context.getBean(SimpleMessage.class);
        System.out.println("Your Message : " + simpleMessage.getMessage());

    }

}