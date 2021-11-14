package com.top.commons.annotation;

import com.top.commons.config.security.basic.BasicUserDetailsService;
import com.top.commons.config.security.basic.ServletFilterExcludeConfig;
import com.top.commons.config.security.basic.UserDetailServiceRegister;
import com.top.commons.config.security.jwt.JwtConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@JwtConfiguration
@Import({UserDetailServiceRegister.class,
        ServletFilterExcludeConfig.class})
public @interface EnableBasicSecurityConfiguration {
    Class<? extends BasicUserDetailsService> detailsService();
}
