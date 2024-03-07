package com.example.coolapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;


    @Autowired
    public DemoController(Coach theCoach){
        myCoach = theCoach;
    }

    Coach theCoach = new CricketCoach();
    DemoController demoController = new DemoController(theCoach);

    @GetMapping("/dailyworkout")
    public String getTeamInfo(){
       return myCoach.getDailyWorkout();
    }


}
