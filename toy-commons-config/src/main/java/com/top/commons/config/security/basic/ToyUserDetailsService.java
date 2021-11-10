package com.top.commons.config.security.basic;

import com.top.commons.config.security.jwt.ToyJwtAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public abstract class ToyUserDetailsService implements UserDetailsService {

    @Override
    public abstract ToyJwtAuthentication loadUserByUsername(String s) throws UsernameNotFoundException;
    public abstract ToyJwtAuthentication loadUserById(Long Id);
}
