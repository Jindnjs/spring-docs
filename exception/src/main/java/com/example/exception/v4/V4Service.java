package com.example.exception.v4;

import org.springframework.stereotype.Service;

@Service
public class V4Service {

    public void findUser(Object obj){
        if(obj == null){
            throw new UserNotFoundException();
        }
    }

    public void findSchedule(Object obj){
        if(obj == null){
            throw new ScheduleNotFoundException();
        }
    }
}
