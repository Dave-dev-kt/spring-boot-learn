package com.learn.springboot.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // Expose endpoint '/' that return hello world

    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    //Expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5K";
    }

    //Expose and endpoint for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune() {return "Today is my day in the name of Jesus";}
}
