package com.learning.spring.workshop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApplication {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		SimpleMessage simpleMessage = (SimpleMessage) context.getBean("simpleMessage");
		String message = simpleMessage.getMessage();
		System.out.println("Your Message : " + message);
	}
}