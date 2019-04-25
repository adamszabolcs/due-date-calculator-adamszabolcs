package com.emarsys.assignment.exception;

public class BadSubmitDate extends RuntimeException {

    BadSubmitDate(String message) {
        super(message);
    }

    BadSubmitDate(String message, Throwable error) {
        super(message, error);
    }

}
