package com.top.commons.config.security;

import com.top.commons.config.security.basic.ToyServletFilterExcludeConfig;
import com.top.commons.config.security.basic.ToyUserDetailServiceRegister;
import com.top.commons.config.security.basic.ToyUserDetailsService;
import com.top.commons.config.security.jwt.EnableJwtConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableJwtConfiguration
@Import({ToyUserDetailServiceRegister.class,
        ToyServletFilterExcludeConfig.class})
public @interface EnableToySecurityConfiguration {
    Class<? extends ToyUserDetailsService> detailsService();
}
