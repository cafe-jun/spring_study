//package com.example.config.autoconfig;
//
//import com.example.config.MyAutoConfig;
//import org.springframework.boot.context.properties.bind.Binder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.env.Environment;
//
//@MyAutoConfig
//public class ServerProperyConfig {
//    @Bean
//    public ServerProperty serverProperty(Environment env) {
//        return Binder.get(env).bind("",ServerProperty.class).get();
////        ServerProperty property = new ServerProperty();
//
////        property.setContextPath(env.getProperty("contextPath"));
////        property.setPort(Integer.parseInt(env.getProperty("port")));
////        return property;
//    }
//}
