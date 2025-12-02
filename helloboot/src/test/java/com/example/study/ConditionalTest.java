package com.example.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class ConditionalTest {
    @Test
    void conditional() {
    // true
//        AnnotationConfigApplicationContext ac1 = new AnnotationConfigApplicationContext();
//        ac1.register(Config1.class);
//        ac1.refresh();
//
//        MyBean myBean1 = ac1.getBean(MyBean.class);

        new ApplicationContextRunner().withUserConfiguration(Config1.class)
                .run(context -> {
                    assertThat(context).hasSingleBean(MyBean.class);
                    assertThat(context).hasSingleBean(Config1.class);
                });

        new ApplicationContextRunner().withUserConfiguration(Config2.class)
            .run(context -> {
                assertThat(context).doesNotHaveBean(MyBean.class);
                assertThat(context).doesNotHaveBean(Config1.class);
            });

//        AnnotationConfigApplicationContext ac2 = new AnnotationConfigApplicationContext();
//        ac2.register(Config1.class);
//        ac2.refresh();
//
//        MyBean myBean22 = ac2.getBean(MyBean.class);


    }


    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Conditional(BooleanCondition.class)
    @interface BooleanConditional {
        boolean value();
    }

    @Configuration
    @BooleanConditional(true)
    static class Config1 {
        @Bean
        MyBean myBean() {
            return new MyBean();
        }
    }

    @Configuration
    @BooleanConditional(false)
    static class Config2 {
        @Bean
        MyBean myBean() {
            return new MyBean();
        }
    }


    static class BooleanCondition implements Condition {

        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(BooleanConditional.class.getName());
            Boolean value = (Boolean)annotationAttributes.get("value");
            return value;
        }
    }

//    static class TrueCondition implements Condition {
//
//        @Override
//        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//            return true;
//        }
//    }
//
//
//    static class FalseCondition implements Condition {
//
//        @Override
//        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//            return false;
//        }
//    }

    static class MyBean {}


}

