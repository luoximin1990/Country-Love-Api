package com.marykay.country.service.exception;

/**
 * Created by wanwei on 16/9/8.
 */
public class ServiceException extends RuntimeException {
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
