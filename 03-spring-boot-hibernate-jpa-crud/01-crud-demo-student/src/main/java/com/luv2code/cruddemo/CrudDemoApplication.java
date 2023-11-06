package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner -> createStudent(studentDAO);
    }

    private void createStudent(StudentDAO studentDAO) {

        // Create the student object
        System.out.print("Creating new student ....");
        Student tempStudent = new Student("David","Adje","davidadjewiz9@gmail.com");

        // Save the student object
        System.out.print("Saving new student ....");
        studentDAO.save(tempStudent);

        // Display the id of the student
        System.out.print("Student saved. Generated id : " + tempStudent.getId());
    }
}
