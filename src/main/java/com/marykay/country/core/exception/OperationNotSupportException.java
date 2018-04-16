package com.marykay.country.core.exception;

/**
 * Created by wanwei on 16/9/12.
 */
public class OperationNotSupportException extends RuntimeException {
    public OperationNotSupportException(String message) {
        super(message);
    }

    public OperationNotSupportException(String message, Throwable cause) {
        super(message, cause);
    }
}
