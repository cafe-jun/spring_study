package backup.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;


@Configuration(proxyBeanMethods = false)
public class Config {


    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet(); // ctrl + h : 타입 하이라키
    }
}
