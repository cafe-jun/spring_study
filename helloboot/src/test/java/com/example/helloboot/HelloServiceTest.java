package com.example.helloboot;

import com.example.helloboot.repository.Hello;
import com.example.helloboot.repository.HelloRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HelloServiceTest {

    @Test
    void helloServiceTest() {
        SimpleHelloService helloService = new SimpleHelloService(helloRepositoryStub);

        String ret = helloService.sayHello("Test");

        assertThat(ret).isEqualTo("Hello Test");
    }

    private static HelloRepository helloRepositoryStub = new HelloRepository (){
        @Override
        public Hello findHello(String name) {
            return null;
        }

        @Override
        public void increaseCount(String name) {

        }
    };

    @Test
    void helloDecorator() {
        HelloDecorator decorator = new HelloDecorator(name -> name);

        String ret = decorator.hello("Test");

        assertThat(ret).isEqualTo("*Test*");
    }
}

