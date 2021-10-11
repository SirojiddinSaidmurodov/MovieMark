package edu.keepeasy.moviemark.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtTokenFilter extends GenericFilterBean {
    private final JwtToken jwtToken;

    @Autowired
    public JwtTokenFilter(JwtToken jwtToken) {
        this.jwtToken = jwtToken;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String token = jwtToken.resolve((HttpServletRequest) servletRequest);
        try {
            if (token != null && jwtToken.validate(token)) {
                Authentication authentication = jwtToken.authenticate(token);
                if (authentication != null) {
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (JwtAuthenticationException e) {
            SecurityContextHolder.clearContext();
            ((HttpServletResponse) servletResponse).sendError(e.getStatus().value());
            throw new JwtAuthenticationException("Token is expired");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
