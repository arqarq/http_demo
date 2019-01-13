package com.example.demo.controller;

import com.example.demo.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private AtomicLong counter = new AtomicLong(); // zabezpieczenie wielowątkowości
    private List<String> names = new LinkedList<>();

    @GetMapping("/greeting")
    public Greeting greet(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), "Hello " + name);
    }

    @PostMapping("/names")
    public void addName(@RequestParam("name") String name) {
        names.add(name);
    }

    @GetMapping("/names")
    public List<String> getNames() {
        return names;
    }
}
