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
}
