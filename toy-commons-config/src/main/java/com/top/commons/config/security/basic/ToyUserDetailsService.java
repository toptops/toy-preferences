package com.top.commons.config.security.basic;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public abstract class ToyUserDetailsService implements UserDetailsService {

    @Override
    public abstract ToyUserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
    public abstract ToyUserDetails loadUserById(Long Id);
}
