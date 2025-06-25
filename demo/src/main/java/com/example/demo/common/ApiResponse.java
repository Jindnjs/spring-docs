package com.example.demo.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
@JsonPropertyOrder({ "statusCode", "message", "body" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private int statusCode;
    private String message;
    private T body;

    private ApiResponse() {}

    private ApiResponse(int statusCode, String message, T body) {
        this.statusCode = statusCode;
        this.message = message;
        this.body = body;
    }

    public static Builder status(BaseCode baseCode) {
        return new Builder(baseCode);
    }

    public static class Builder {
        private int statusCode;
        private String message;

        private Builder(BaseCode baseCode) {
            statusCode = baseCode.getStatus().value();
            message = baseCode.getMessage();
        }

//        public <U> ResponseEntity<ApiResponse<U>> body(){
//            return ResponseEntity
//                    .status(response.statusCode)
//                    .body(new ApiResponse<>(response.statusCode,response.message,null));
//        }

        public <T> ResponseEntity<ApiResponse<T>> body(T body){
            return ResponseEntity
                    .status(statusCode)
                    .body(new ApiResponse<>(statusCode,message,body));
        }
    }
}
