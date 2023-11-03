package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    // Define our init method

    @PostConstruct
    public void doMyStartUpStuff() {
        System.out.print("In doMyStartUpStuff" + getClass().getSimpleName());
    }

    //Define our destroy method

    @PreDestroy
    public void doMyCleanUpStuff() {
        System.out.print("In doMyCleanUpStuff" + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout(){
        return "Practice fast bowling for 15 minutes in the name of Jesus";
    }
}
