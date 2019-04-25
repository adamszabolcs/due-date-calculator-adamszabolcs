package com.emarsys.assignment.exception;

public class BadSubmitDate extends RuntimeException {

    public BadSubmitDate(String message) {
        super(message);
    }

    public BadSubmitDate(String message, Throwable error) {
        super(message, error);
    }

}
