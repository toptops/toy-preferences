package com.top.commons.config.security.oauth2;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BasicOAuth2AuthenticationHandlerService {
    String getProcessingSuccessUrl(HttpServletRequest request, HttpServletResponse response, Authentication authentication);
    String getProcessingFailureUrl(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception);
}
