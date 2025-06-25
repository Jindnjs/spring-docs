package com.example.demo;


import com.example.demo.common.ApiResponse;
import com.example.demo.common.TestSuccess;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @PostMapping("/test")
    public ResponseEntity<ApiResponse<TestDto>> test(
             @RequestBody TestDto testDto
    ) {
         return ApiResponse.status(TestSuccess.TEST_SUCCESS).body(testDto);
        //return ApiResponse.status(TestEnum.TEST_SUCCESS).body();
    }

//    @GetMapping("test2")
//    public ResponseEntity<ApiResponse<TestDto>> test2() {
//
//        throw new TestException();
//
//        //TestDto testDto = new TestDto("이름1", 13);
//        //return ApiResponse.status(TestEnum.TEST_SUCCESS).body(testDto);
//    }

}
