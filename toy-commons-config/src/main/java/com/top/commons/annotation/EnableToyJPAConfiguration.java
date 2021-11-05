package com.top.commons.annotation;

import com.top.commons.config.db.CommonJPAConfigureSelector;
import com.top.commons.config.db.CommonJPAContextRegister;
import com.top.commons.config.db.enums.ToyJPAModule;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableTransactionManagement
@Import({CommonJPAContextRegister.class,
        CommonJPAConfigureSelector.class
})
public @interface EnableToyJPAConfiguration {
    ToyJPAModule module();
    String[] entityBasePackages();
}
