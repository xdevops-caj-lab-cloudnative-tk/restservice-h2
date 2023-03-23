package com.example.restservice.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReturnCode {
    SUCCESS(0, "OK"),
    FAILED(-1, "Failed");
    // Add more codes here

    private final int code;
    private final String message;
}
