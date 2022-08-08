package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class StartPageController {

    @GetMapping(value = "/user")
    public String openStartPage() {
        return "/user";
    }

    @GetMapping(value = "/admin")
    public String openStartAdminPage() {
        return "/admin";
    }
}
