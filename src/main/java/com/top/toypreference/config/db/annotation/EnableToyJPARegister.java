package com.top.toypreference.config.db.annotation;

import com.top.toypreference.config.db.jpa.ToyJPARegister;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ToyJPARegister.class})
public @interface EnableToyJPARegister {
    String[] entityBasePackages() default {"com.top.*"};
    String[] repositoryBasePackages() default {"com.top.*"};
}
