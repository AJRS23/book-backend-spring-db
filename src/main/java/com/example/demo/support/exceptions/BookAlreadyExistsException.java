package com.example.demo.support.exceptions;

public class BookAlreadyExistsException extends Exception {
    public BookAlreadyExistsException() {
        super("A book with that name and author already exists.");
    }
}
