package com.example.helloboot;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

//@SpringBootApplication
public class HellobootApplication {

    public static void main(String[] args) {
        GenericApplicationContext applicationContext = new GenericApplicationContext();

        applicationContext.registerBean(HelloController.class);
        applicationContext.refresh();

        ServletWebServerFactory factory = new TomcatServletWebServerFactory();

        WebServer webServer = factory.getWebServer(servletContext -> {
            servletContext.addServlet("frontcontroller", new HttpServlet() {
                @Override
                public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
                    System.out.println(req.getRequestURI().equals("/hello") + " " + req.getMethod());

                    if(req.getRequestURI().equals("/hello") && req.getMethod().equals("GET")) {

                        System.out.println(req.getRequestURI() + " " + req.getMethod());

                        String name = req.getParameter("name");

                        HelloController helloController1 = applicationContext.getBean(HelloController.class);

                        String ret = helloController1.hello(name);

                        res.setStatus(HttpStatus.OK.value());
                        res.setContentType(MediaType.TEXT_PLAIN_VALUE);
                        res.getWriter().println(ret);

                    }  else {
                        res.setStatus(HttpStatus.NOT_FOUND.value());
                    }
                }
            }).addMapping("/*");
        });
        webServer.start();

    }

}
