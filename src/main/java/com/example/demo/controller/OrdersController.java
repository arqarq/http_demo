package com.example.demo.controller;

import com.example.demo.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class OrdersController {
    private List<Order> orders = new LinkedList<>();

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orders;
    }

    @PostMapping("/orders")
    public ResponseEntity<?> addOrder(@RequestBody Order order) {
        orders.add(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
