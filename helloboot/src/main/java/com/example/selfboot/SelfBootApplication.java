package com.example.selfboot;


import com.example.helloboot.HelloController;
import com.example.selfboot.self.SelfController;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.context.support.GenericWebApplicationContext;

import java.io.IOException;

//@SpringBootApplication
public class SelfBootApplication {
    public static void main(String[] args) {
//        SpringApplication.run(SelfBootApplication.class);

        GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();

        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();

        WebServer server = serverFactory.getWebServer(servletContext -> {
            SelfController selfController = new SelfController();
            servletContext.addServlet("helloServlet", new HttpServlet() {

                @Override
                public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
                    if (req.getRequestURI().equals("/self") && req.getMethod().equals("GET")) {
                       String name = req.getParameter("name");
                       String selfRes = selfController.hello(name);

                       res.setStatus(HttpStatus.OK.value());
                       res.setContentType(MediaType.TEXT_PLAIN_VALUE);
                       res.getWriter().println(selfRes);

                    } else {
                        res.setStatus(HttpStatus.NOT_FOUND.value());
                    }

                }
            }).addMapping("/*");
        });

        server.start();
    }
}
