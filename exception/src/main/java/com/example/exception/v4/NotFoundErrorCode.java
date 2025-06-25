package com.example.exception.v4;

import com.example.exception.v4.common.ErrorCode;
import org.springframework.http.HttpStatus;

public enum NotFoundErrorCode implements ErrorCode {

    SCHEDULE_NOT_FOUND(HttpStatus.NOT_FOUND, "NF01", "존재하지 않는 일정입니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "NF02", "존재하지 않는 사용자입니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    NotFoundErrorCode(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public HttpStatus getStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
