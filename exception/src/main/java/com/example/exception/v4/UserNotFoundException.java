package com.example.exception.v4;

import com.example.exception.v4.common.CommonExceoption;
import com.example.exception.v4.common.ErrorCode;

public class UserNotFoundException extends CommonExceoption{
    @Override
    public ErrorCode getErrorCode() {
        return NotFoundErrorCode.USER_NOT_FOUND;
    }
}
