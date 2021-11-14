package com.top.commons.config.security.jwt;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({JwtAuthenticationFilter.class,
        JwtProvider.class})
public @interface JwtConfiguration {
}
