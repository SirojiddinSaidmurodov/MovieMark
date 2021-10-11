package edu.keepeasy.moviemark.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final JwtTokenFilter filter;

    @Autowired
    public JwtConfigurer(JwtTokenFilter filter) {
        this.filter = filter;
    }

    @Override
    public void configure(HttpSecurity security) {
        security.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }

}
