package com.top.commons.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableJpaRepositories(
        entityManagerFactoryRef = "toyJPABasicEntityManagerFactory",
        transactionManagerRef = "toyJPABasicTransactionManager"
)
public @interface EnableToyBasicJpaRepositories {
    @AliasFor(annotation = EnableJpaRepositories.class, attribute = "basePackages")
    String[] basePackages() default {};
}
