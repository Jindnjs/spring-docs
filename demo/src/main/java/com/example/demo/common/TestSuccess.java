package com.example.demo.common;

import org.springframework.http.HttpStatus;

public enum TestSuccess implements com.example.demo.common.BaseCode {
    TEST_SUCCESS(HttpStatus.OK, "성공했습니다.");

    private HttpStatus status;
    private String message;

    TestSuccess(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
