package com.example.demo.support.exceptions;

public class BookNotFoundException extends Exception {
    public BookNotFoundException() {
        super("The id doesn't match any book.");
    }
}
