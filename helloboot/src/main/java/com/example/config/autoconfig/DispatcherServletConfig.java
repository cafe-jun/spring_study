package com.example.config.autoconfig;

import com.example.config.MyAutoConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;


@MyAutoConfig
public class DispatcherServletConfig {
    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }
}
