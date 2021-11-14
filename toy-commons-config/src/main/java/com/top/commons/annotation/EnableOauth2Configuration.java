package com.top.commons.annotation;

import com.top.commons.config.security.oauth2.BasicOAuth2UserProcessor;
import com.top.commons.config.security.oauth2.OAuth2Configuration;
import com.top.commons.config.security.oauth2.OAuth2UserProcessorRegister;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@OAuth2Configuration
@Import({OAuth2UserProcessorRegister.class})
public @interface EnableOauth2Configuration {
    Class<? extends BasicOAuth2UserProcessor> userProcessor();
}
