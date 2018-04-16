package com.marykay.country.core.exception;

/**
 * Created by wanwei on 2016/9/22.
 */
public class BadCredentialsException extends AuthenticationException {
    public BadCredentialsException(String message) {
        super(message);
    }

    public BadCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }
}
