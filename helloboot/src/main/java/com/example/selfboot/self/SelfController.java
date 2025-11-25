package com.example.selfboot.self;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class SelfController {

//    @GetMapping ("/self")
    public String hello(String name){
        return "self "+name;
    }
}
