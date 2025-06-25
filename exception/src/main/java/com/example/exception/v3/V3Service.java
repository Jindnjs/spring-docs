package com.example.exception.v3;

import com.example.exception.v2.ScheduleNotFoundException;
import com.example.exception.v2.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class V3Service {

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
