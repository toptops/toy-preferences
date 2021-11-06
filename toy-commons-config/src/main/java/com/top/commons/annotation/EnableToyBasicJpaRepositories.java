package com.top.commons.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableJpaRepositories
public @interface EnableToyBasicJpaRepositories {
    @AliasFor(annotation = EnableJpaRepositories.class, attribute = "basePackages")
    String[] basePackages() default {};
    
    @AliasFor(annotation = EnableJpaRepositories.class, attribute = "basePackageClasses")
    Class<?>[] basePackageClasses() default {};

    @AliasFor(annotation = EnableJpaRepositories.class, attribute = "entityManagerFactoryRef")
    String entityManagerFactoryRef() default "toyJPABasicEntityManagerFactory";

    @AliasFor(annotation = EnableJpaRepositories.class, attribute = "transactionManagerRef")
    String transactionManagerRef() default "toyJPABasicTransactionManager";
}
