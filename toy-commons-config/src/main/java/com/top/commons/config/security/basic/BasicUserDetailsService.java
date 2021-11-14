package com.top.commons.config.security.basic;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public abstract class BasicUserDetailsService implements UserDetailsService {
    @Override
    public abstract CommonUserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
    public abstract CommonUserDetails loadUserById(Long Id);
}
