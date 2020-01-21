package com.learning.spring.workshop.config;


import com.learning.spring.workshop.model.SimpleMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@ComponentScan(basePackages = {"com.learning.spring.workshop"})
@Configuration
public class WebMVCConfig extends WebMvcConfigurationSupport {
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("WEB-INF/templates/");
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public SimpleMessage simpleMessage() {
        SimpleMessage simpleMessage = new SimpleMessage();
        simpleMessage.setMessage("Hello Spring MVC WebApp with Java config");
        return simpleMessage;
    }
}