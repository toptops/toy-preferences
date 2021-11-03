package com.top.toypreference.config;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ToyJPARegister.class})
public @interface EnableToyJPARegister {
    String[] entityBasePackages() default {"com.top.*"};
    String[] repositoryBasePackages() default {"com.top.*"};
}
