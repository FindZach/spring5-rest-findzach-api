package com.findzach.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zach S <zach@findzach.com>
 * @since 5/7/2021
 */
@RestController
public class HomeController {

    @RequestMapping("/api/home")
    public String home() {
        return "Welcome to FindZach's Backend REST API";
    }
}
