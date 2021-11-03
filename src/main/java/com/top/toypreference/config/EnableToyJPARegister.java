package com.top.toypreference.config;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ToyJPARegister.class})
@Component
public @interface EnableToyJPARegister {
    String[] basePackage() default {};
}
