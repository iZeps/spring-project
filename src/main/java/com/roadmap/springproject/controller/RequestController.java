package com.roadmap.springproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class RequestController {

    @GetMapping("library")
    public String library(Model model) {
        log.info("library message called");
        model.addAttribute("message", "Welcome to Spring Boot");
        return "library";
    }

}
