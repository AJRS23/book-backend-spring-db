package com.example.demo.support.exceptions;

public class BookNameFieldRequiredException extends Exception {
    public BookNameFieldRequiredException() {
        super("Name field is required.");
    }
}
