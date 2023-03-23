package com.example.restservice.customer;

import com.example.restservice.exception.ResourceNotFoundException;

public class CustomerNotFoundException extends ResourceNotFoundException {
    public CustomerNotFoundException(Long id) {
        super("Could not find customer " + id);
    }
}
