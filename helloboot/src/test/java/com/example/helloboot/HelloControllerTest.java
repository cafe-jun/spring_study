package com.example.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloControllerTest {
    @Test
    void helloController() {
        HelloController helloController = new HelloController(name -> name);
        String ret = helloController.sayHello("Spring");
        assertThat(ret).isEqualTo("Spring");
    }

    @Test
    void helloController2() {
        HelloController helloController = new HelloController(name -> name);
    }
}
