package com.emarsys.assignment.exception;

public class BadTurnAroundTime extends RuntimeException {

    public BadTurnAroundTime(String message) {
        super(message);
    }

    public BadTurnAroundTime(String message, Throwable error) {
        super(message, error);
    }

}
