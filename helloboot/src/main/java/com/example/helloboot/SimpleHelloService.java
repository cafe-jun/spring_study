package com.example.helloboot;

import org.springframework.stereotype.Service;

@MyComponent
public class SimpleHelloService implements HelloService {

    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}
