package com.learning.spring.workshop.boot.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("message", "Hello Spring Boot Web MVC with thymeleaf");
        return "index";
    }
}
