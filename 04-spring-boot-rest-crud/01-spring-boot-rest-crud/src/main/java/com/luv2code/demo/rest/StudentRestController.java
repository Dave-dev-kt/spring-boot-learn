package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudent;

    //Define @PostConstruct to load the student data

    @PostConstruct
    public void loadData(){
        theStudent = new ArrayList<>();

        theStudent.add(new Student("David","Adje"));
        theStudent.add(new Student("Aude","Oka"));
        theStudent.add(new Student("Evrard","Angui"));
    }

    //define endpoint for /students - return a list of all the students
    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudent;
    }

    //define endpoint for /students/{studentId} - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        //Just index into the list ... keep it simple for now

        return theStudent.get(studentId);
    }

}
