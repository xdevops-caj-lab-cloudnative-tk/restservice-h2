package com.example.restservice.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super("Could not find resource " + id);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
