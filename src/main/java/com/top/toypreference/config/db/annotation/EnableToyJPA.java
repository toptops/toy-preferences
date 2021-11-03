package com.top.toypreference.config.db.annotation;

import com.top.toypreference.config.db.jpa.ToyJPAConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ToyDatasourceConfig.class, ToyJPAConfig.class})
public @interface EnableToyJPA {
}
