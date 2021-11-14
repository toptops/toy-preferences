package com.top.commons.config.security.basic;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

public abstract class CommonUserDetails implements OAuth2User, UserDetails {
    public abstract long getId();
}
