package com.example.exception.v1;

import org.springframework.stereotype.Service;

@Service
public class V1Service {


    public void findUser(Object obj){
        if(obj == null){
            throw new IllegalArgumentException("User is null");
        }
    }

    public void findSchedule(Object obj){
        if(obj == null){
            throw new IllegalArgumentException("Schedule is null");
        }
    }
}
