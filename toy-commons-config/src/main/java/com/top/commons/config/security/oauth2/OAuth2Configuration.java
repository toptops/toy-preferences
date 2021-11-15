package com.top.commons.config.security.oauth2;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({HttpCookieOAuth2AuthorizationRequestRepository.class,
        BasicOAuth2UserService.class,
        OAuth2AuthenticationSuccessHandler.class,
        OAuth2AuthenticationFailureHandler.class})
public @interface OAuth2Configuration {
}
