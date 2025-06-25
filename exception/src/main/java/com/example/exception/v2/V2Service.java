package com.example.exception.v2;

import org.springframework.stereotype.Service;

@Service
public class V2Service {

    public void findUser(Object obj){
        if(obj == null){
            throw new UserNotFoundException("User is null");
        }
    }

    public void findSchedule(Object obj){
        if(obj == null){
            throw new ScheduleNotFoundException("Schedule is null");
        }
    }
}
