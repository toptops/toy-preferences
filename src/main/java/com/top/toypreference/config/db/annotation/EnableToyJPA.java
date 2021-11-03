package com.top.toypreference.config.db.annotation;

import com.top.toypreference.config.db.jpa.ToyJPAConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ToyJPAConfig.class})
@EnableJpaRepositories
public @interface EnableToyJPA {
    @AliasFor(annotation = EnableJpaRepositories.class, attribute = "toyJPAEntityManagerFactory")
    String entityManagerFactoryRef() default "toyJPAEntityManagerFactory";

    @AliasFor(annotation = EnableJpaRepositories.class, attribute = "toyJPATransactionManager")
    String transactionManagerRef() default "toyJPATransactionManager";

    @AliasFor(annotation = EnableJpaRepositories.class, attribute = "basePackages")
    String basePackages() default "com.top.*";
}
