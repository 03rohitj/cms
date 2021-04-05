package com.shacklebolt.customer_management.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @GetMapping
    public String sayHello(){
        return "Here we go again, Hello World!";
    }
}
