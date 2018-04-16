package com.marykay.country.core.exception;

/**
 * Created by wanwei on 2016/9/22.
 */
public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
