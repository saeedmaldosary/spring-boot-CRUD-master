package com.example.demo.exception;

// We have to types of exceptions:
// run time and check exception(with try and catch)
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        // Super mean sending to the super constructor or RuntimeException class
        super(message);
    }
}
