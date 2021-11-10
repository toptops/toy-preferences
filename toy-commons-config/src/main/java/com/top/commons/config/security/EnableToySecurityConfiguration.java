package com.top.commons.config.security;

import com.top.commons.config.security.basic.ToyUserDetailServiceRegister;
import com.top.commons.config.security.basic.ToyUserDetailsService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ToyUserDetailServiceRegister.class})
@ComponentScan({
        "com.top.commons.config.security.jwt"
})
public @interface EnableToySecurityConfiguration {
    Class<? extends ToyUserDetailsService> detailsService();
}
