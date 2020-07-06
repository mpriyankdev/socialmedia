package com.socialmedia.exception;

public class InvalidParameterException extends RuntimeException {

    public InvalidParameterException() {
        super();
    }

    public InvalidParameterException(String message) {
        super(message);
    }

    public InvalidParameterException(String message, Throwable e) {
        super(message, e);
    }
}
