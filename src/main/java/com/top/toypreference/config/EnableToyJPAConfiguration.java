package com.top.toypreference.config;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableToyJPARegister
public @interface EnableToyJPAConfiguration {
    @AliasFor(annotation = EnableToyJPARegister.class, attribute = "entityBasePackage")
    String[] entityBasePackage() default {"com.top.*"};
    @AliasFor(annotation = EnableToyJPARegister.class, attribute = "repositoryBasePackage")
    String[] repositoryBasePackage() default {"com.top.*"};
}
