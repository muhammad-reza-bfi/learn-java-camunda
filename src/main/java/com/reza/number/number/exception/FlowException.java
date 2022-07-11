package com.reza.number.number.exception;

public class FlowException extends Exception {

    public FlowException(String message, Throwable cause) {
        super(message, cause);
    }

    public FlowException(String message) {
        super(message);
    }
}