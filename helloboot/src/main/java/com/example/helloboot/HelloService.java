package com.example.helloboot;

import com.example.helloboot.repository.Hello;
import org.springframework.stereotype.Component;


public interface HelloService {
    String sayHello(String name);

    default int countOf(String name) {
        return 0;
    };
}
