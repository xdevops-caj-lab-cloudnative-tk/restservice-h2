package com.example.restservice.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> ApiResponse success(T data) {
        return ApiResponse.builder()
                .code(ReturnCode.SUCCESS.getCode())
                .message(ReturnCode.SUCCESS.getMessage())
                .data(data)
                .build();
    }

    public static ApiResponse success() {
        return success(null);
    }

    public static ApiResponse fail(Integer code, String message) {
        return ApiResponse.builder()
                .code(code)
                .message(message)
                .build();
    }

    public static ApiResponse fail(ReturnCode returnCode) {
        return fail(returnCode.getCode(), returnCode.getMessage());
    }

    public static ApiResponse fail() {
        return fail(ReturnCode.FAILED);
    }

    public static ApiResponse fail(String message) {
        return ApiResponse.builder()
                .code(ReturnCode.FAILED.getCode())
                .message(message)
                .build();
    }
}
