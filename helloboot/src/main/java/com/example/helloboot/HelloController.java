package com.example.helloboot;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@MyComponent
public class HelloController {

    private final HelloService helloService;
//    private ApplicationContext applicationContext;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String sayHello (String name) {
        if(name == null || name.trim().isEmpty()) throw new IllegalArgumentException();
        return helloService.sayHello(name);
    }

    @GetMapping("/count")
    public String count(String name) {
        return name+":"+helloService.countOf(name);
    }

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        System.out.println("setApplicationContext");
//    }
}
