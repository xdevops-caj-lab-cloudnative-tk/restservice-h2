package com.example.restservice.exception;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(Long id) {
        super("The resource already exists " + id);
    }

    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
}
