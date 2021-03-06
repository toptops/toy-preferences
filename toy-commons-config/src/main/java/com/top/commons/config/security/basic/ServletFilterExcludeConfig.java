package com.top.commons.config.security.basic;

import com.top.commons.config.security.jwt.JwtAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletFilterExcludeConfig {

    @Bean
    public FilterRegistrationBean jwtAuthenticationFilterExclude(JwtAuthenticationFilter jwtAuthenticationFilter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(jwtAuthenticationFilter);
        registration.setEnabled(false);
        return registration;
    }
}
