package com.example.coolapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {


    @Override
    public String getDailyWorkout(){
        return "Practice fast bowling for 50 minutes";
    }

    public CricketCoach() {
    }
}
