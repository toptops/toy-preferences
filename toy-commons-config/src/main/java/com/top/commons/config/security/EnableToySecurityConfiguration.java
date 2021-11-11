package com.top.commons.config.security;

import com.top.commons.config.security.basic.ToyUserDetailServiceRegister;
import com.top.commons.config.security.basic.ToyUserDetailsService;
import com.top.commons.config.security.jwt.JwtAuthenticationFilter;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ToyUserDetailServiceRegister.class,
        JwtAuthenticationFilter.class})
public @interface EnableToySecurityConfiguration {
    Class<? extends ToyUserDetailsService> detailsService();
}
