package com.example.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloConttrollerTest {
    @Test
    void helloController() {
        HelloController helloController = new HelloController(name -> name);

        String ret = helloController.hello("Spring");

        Assertions.assertThat(ret).isEqualTo("Spring");

    }

    @Test
    void helloController2() {
        HelloController helloController = new HelloController(name -> name);
    }
}
