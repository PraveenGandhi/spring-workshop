package com.learning.spring.workshop.controller;

import com.learning.spring.workshop.model.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private final SimpleMessage simpleMessage;

    @Autowired
    public HomeController(SimpleMessage simpleMessage) {
        this.simpleMessage = simpleMessage;
    }

    @RequestMapping(value = "/")
    public String index(ModelMap map) {
        map.addAttribute("message", simpleMessage.getMessage());
        return "index";
    }
}
