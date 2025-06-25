package com.example.exception.v4;

import com.example.exception.v2.ScheduleNotFoundException;
import com.example.exception.v2.UserNotFoundException;
import com.example.exception.v4.common.CommonExceoption;
import com.example.exception.v4.common.ErrorCode;
import com.example.exception.v4.common.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class V4GlobalExceptionHandler {

    @ExceptionHandler(CommonExceoption.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(CommonExceoption e) {
        ErrorCode errorCode = e.getErrorCode();
        return ResponseEntity
                .status(errorCode.getStatus())
                .body(ErrorResponse.from(errorCode));
    }
}
