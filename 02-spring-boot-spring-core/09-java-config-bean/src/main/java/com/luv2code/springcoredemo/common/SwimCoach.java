package com.luv2code.springcoredemo.common;

public class SwimCoach implements Coach {

    public SwimCoach(){
        System.out.print("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as warm a up";
    }
}
