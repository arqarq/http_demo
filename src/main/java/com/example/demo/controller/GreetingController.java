package com.example.demo.controller;

import com.example.demo.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private int counter = 0;

    @GetMapping("/greeting")
    public Greeting greet(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter++, "Hello " + name);
    }
}
