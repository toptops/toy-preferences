package com.top.commons.config.security.basic;

import com.top.commons.config.security.jwt.JwtAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToyServletFilterExcludeConfig {

    @Bean
    public FilterRegistrationBean registration(JwtAuthenticationFilter jwtAuthenticationFilter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(jwtAuthenticationFilter);
        registration.setEnabled(false);
        return registration;
    }
}
