package com.top.commons.annotation;

import com.top.commons.config.db.CommonJpaConfigureSelector;
import com.top.commons.config.db.CommonJpaContextRegister;
import com.top.commons.config.db.enums.ToyJpaModule;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableTransactionManagement
@EnableJpaRepositories
@Import({CommonJpaContextRegister.class,
        CommonJpaConfigureSelector.class
})
public @interface EnableToyJpaConfiguration {
    ToyJpaModule module();
    String[] entityBasePackages();

    @AliasFor(annotation = EnableJpaRepositories.class, attribute = "basePackages")
    String[] basePackages() default {};

    @AliasFor(annotation = EnableJpaRepositories.class, attribute = "basePackageClasses")
    Class<?>[] basePackageClasses() default {};

    @AliasFor(annotation = EnableJpaRepositories.class, attribute = "entityManagerFactory")
    String entityManagerFactoryRef() default "entityManagerFactory";

    @AliasFor(annotation = EnableJpaRepositories.class, attribute = "transactionManager")
    String transactionManagerRef() default "transactionManager";
}
