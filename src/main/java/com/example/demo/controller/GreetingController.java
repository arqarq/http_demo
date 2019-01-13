package com.example.demo.controller;

import com.example.demo.model.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> addName(@RequestParam("name") String name) {
        names.add(name);
        return new ResponseEntity<>(":)", HttpStatus.CREATED);
    }

    @GetMapping("/names")
    public ResponseEntity<?> getNames() {
//        return names;
        return new ResponseEntity<>(names, HttpStatus.I_AM_A_TEAPOT);
    }

    @GetMapping("/names/{i}")
    public String getName(@PathVariable("i") int i) {
        return names.get(i);
    }
}
