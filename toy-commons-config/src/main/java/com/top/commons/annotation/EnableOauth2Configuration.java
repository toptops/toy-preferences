package com.top.commons.annotation;

import com.top.commons.config.security.oauth2.*;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@OAuth2Configuration
@Import({OAuth2UserProcessorRegister.class,
        OAuth2AuthenticationHandlerServiceRegister.class})
public @interface EnableOauth2Configuration {
    Class<? extends BasicOAuth2UserProcessor> userProcessor();
    Class<? extends BasicOAuth2AuthenticationHandlerService> authHandlerService();
}
