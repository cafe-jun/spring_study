package com.example.helloboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class HelloDecorator {

    private final HelloService helloService;

    public HelloDecorator(HelloService helloService) {
        this.helloService = helloService;
    }


    public String hello(String name) {
        return "*"+helloService.sayHello(name)+"*";
    }

    public int countOf(String name) { return helloService.countOf(name); }

}
