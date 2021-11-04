package com.top.commons.annotation;

import com.top.commons.config.db.ToyDatasourceConfig;
import com.top.commons.config.db.jpa.ToyJPAConfig;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ToyDatasourceConfig.class, ToyJPAConfig.class})
@EnableJpaRepositories
public @interface EnableToyJPA {
    @AliasFor(annotation = EnableJpaRepositories.class, attribute = "entityManagerFactoryRef")
    String entityManagerFactoryRef() default "toyJPAEntityManagerFactory";

    @AliasFor(annotation = EnableJpaRepositories.class, attribute = "transactionManagerRef")
    String transactionManagerRef() default "toyJPATransactionManager";

    @AliasFor(annotation = EnableJpaRepositories.class, attribute = "basePackages")
    String basePackages() default "com.top.*";
}
