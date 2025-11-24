package com.example.helloboot;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//@SpringBootApplication
@Configuration
@ComponentScan
public class HellobootApplication {

//
//    @Bean
//    public ServletWebServerFactory servletWebServerFactory () {
//        return new TomcatServletWebServerFactory();
//    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet(); // ctrl + h : 타입 하이라키
    }

    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class,args);
    }



}
