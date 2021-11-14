package com.top.commons.config.security.jwt;

import com.top.commons.config.security.basic.BasicUserDetailsService;
import com.top.commons.config.security.basic.CommonUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;
    private final BasicUserDetailsService basicUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = request.getHeader(HttpHeaders.AUTHORIZATION).substring(7);

            if(StringUtils.hasText(jwt) && jwtProvider.validation(jwt)) {
                Long userId = jwtProvider.getUserIdFromToken(jwt);
                CommonUserDetails userDetails = basicUserDetailsService.loadUserById(userId);
                UsernamePasswordAuthenticationToken authentication = getAuthToken(userDetails);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            System.out.println("토큰 없다");
        }
        filterChain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthToken(CommonUserDetails userDetails) {
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

}

