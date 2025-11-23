package com.example.helloboot;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

//@RestController
public class HelloController {
//    @GetMapping("/hello")
    public String hello (
            String name
    ) {
        SimpleHelloService simpleHelloService = new SimpleHelloService();
        return simpleHelloService.hello(Objects.requireNonNull(name));
    }
}
