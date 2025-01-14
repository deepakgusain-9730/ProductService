package com.learning.firstspringapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class FirstAPIController {

    @GetMapping("/sayhello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return "Hello World " + name;
    }

    @GetMapping("/saybye")
    public String sayBye() {
        return "Bye World";
    }
}
