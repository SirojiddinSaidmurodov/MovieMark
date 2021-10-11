package edu.keepeasy.moviemark.security;

import org.springframework.http.HttpStatus;

import javax.security.sasl.AuthenticationException;

public class JwtAuthenticationException extends AuthenticationException {
    private HttpStatus status;

    public JwtAuthenticationException(String message) {
        super(message);
    }

    public JwtAuthenticationException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
