package com.narendra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/orders")
    public String getUserOrders() {
        String response = restTemplate.getForObject("http://order-service/orders", String.class);
        return "User's Orders: " + response;
    }
}
