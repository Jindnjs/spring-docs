package com.example.exception.v4.common;

public abstract class CommonExceoption extends RuntimeException {

    public abstract ErrorCode getErrorCode();

    @Override
    public String getMessage() {
        return getErrorCode().getMessage();
    }
}
