package com.example.interfaceimple.service;

import com.example.interfaceimple.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Test;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

//    public int asdf(Test test) {
//        return testRepository.getInt();
//    }
    public int dsl(){
        return testRepository.dslInt();
    }
}
