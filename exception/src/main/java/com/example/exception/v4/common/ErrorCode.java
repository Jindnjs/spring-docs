package com.example.exception.v4.common;

import org.springframework.http.HttpStatus;

public interface ErrorCode {
    String getCode();
    HttpStatus getStatus();
    String getMessage();
}
