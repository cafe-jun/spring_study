package com.example.helloboot;
//
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.DispatcherServlet;

//@SpringBootApplication
@MySpringBootAnnotation
public class HellobootApplication {

//


    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class,args);
    }
}


