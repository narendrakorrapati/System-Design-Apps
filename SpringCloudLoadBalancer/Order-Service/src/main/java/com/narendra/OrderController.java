package com.narendra;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private static int COUNTER = 1;
    @GetMapping
    public String getOrders(HttpServletRequest request) {

        return "Order List from " + UUID.randomUUID() + ". My Count:" + (COUNTER ++);
    }
}