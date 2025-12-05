package com.example.helloboot;

import com.example.helloboot.repository.Hello;
import com.example.helloboot.repository.HelloRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface  FastUnitTest {

}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD})
@interface  UnitTest {
}


public class HelloServerTest {

    @Test
    void simpleHelloServer() {
        SimpleHelloService helloService = new SimpleHelloService(getHelloRepository());
        String ret =  helloService.sayHello("Spring");
        Assertions.assertThat(ret).isEqualTo("Hello Spring");
    }

    private static HelloRepository getHelloRepository() {
        return new HelloRepository() {
            @Override
            public Hello findHello(String name) {
                return null;
            }

            @Override
            public void increaseCount(String name) {

            }
        };
    }

    @Test
    void failHelloController() {
        HelloController helloController = new HelloController(name -> name);

        Assertions.assertThatThrownBy(() -> {
            String ret = helloController.sayHello(null);
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            String ret = helloController.sayHello("");
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void helloDecorator() {
        HelloDecorator decorator = new HelloDecorator(name -> name);
        String ret = decorator.hello("Test");
        Assertions.assertThat(ret).isEqualTo("*Test*");
    }
}
