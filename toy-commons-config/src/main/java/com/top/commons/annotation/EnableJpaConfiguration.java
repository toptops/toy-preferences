package com.top.commons.annotation;

import com.top.commons.config.db.enums.JpaModule;
import com.top.commons.config.db.jpa.CommonJpaConfigureSelector;
import com.top.commons.config.db.jpa.CommonJpaContextRegister;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({CommonJpaContextRegister.class,
        CommonJpaConfigureSelector.class
})
public @interface EnableJpaConfiguration {
    JpaModule module();
    String[] basePackages();
}
