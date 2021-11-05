package com.top.commons.annotation;

import com.top.commons.config.db.CommonJpaConfigureSelector;
import com.top.commons.config.db.CommonJpaContextRegister;
import com.top.commons.config.db.enums.ToyJpaModule;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableTransactionManagement
@EnableJpaRepositories
@Import({CommonJpaContextRegister.class,
        CommonJpaConfigureSelector.class
})
public @interface EnableToyJpaConfiguration {
    ToyJpaModule module();
    String[] basePackages();
}
