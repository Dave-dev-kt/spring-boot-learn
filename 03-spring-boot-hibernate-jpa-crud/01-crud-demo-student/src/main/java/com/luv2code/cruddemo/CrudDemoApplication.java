package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner -> {
            //createStudent(studentDAO);

            createMultipleStudent(studentDAO);

            //readStudent(studentDAO);

            //queryForStudent(studentDAO);

            //queryForStudentByLastName(studentDAO);

            //updateStudent(studentDAO);

            //deleteStudent(studentDAO);

            //deleteAllStudent(studentDAO);
        };
    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        System.out.println("Deleting all students");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted row count : " + numRowsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {

        int studentId = 3;
        System.out.println("Deleting the student id : " + studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {

        //retrieve student based on the id
        int theId = 1;
        System.out.println("Getting the student with id : " + theId);
        Student myStudent = studentDAO.findById(theId);

        // change firstname to Scobby
        System.out.println("Updating the student ...");

        myStudent.setFirstName("David");

        //Update the student
        studentDAO.updateStudent(myStudent);

        //display the updated student

        System.out.println("updated student : " + myStudent);
    }

    private void queryForStudentByLastName(StudentDAO studentDAO) {

        // get list of students
        List<Student> theStudent = studentDAO.findByLastName("Adje");

        // Display list of students
        for(Student tempStudent : theStudent){
            System.out.println(tempStudent);
        }
    }

    private void queryForStudent(StudentDAO studentDAO) {

        // get a list of students
        List<Student> theStudents = studentDAO.findAll();

        //display the list of student

        for(Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {

        // create a student object
        System.out.println("Creating student ...");
        Student tempStudent = new Student("Davis","Adje","davisadje@mail.com");

        //save the student
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        //display id of the student
        int theId = tempStudent.getId();
        System.out.println("Saved student. Generated id : " + theId);

        //retrieve student based on id
        System.out.println("Retrieving the student with id : " + theId);
        Student myStudent = studentDAO.findById(theId);

        //display student

        System.out.println("Found the student : " + myStudent);
    }

    private void createMultipleStudent(StudentDAO studentDAO)
    {
        //create multiple students
        System.out.println("Creating 3 students");
        Student tempStudent1 = new Student("Paul","ADJE","pauladje@gmail.com");
        Student tempStudent2 = new Student("Paule","ADJE","pauleadje@gmail.com");
        Student tempStudent3 = new Student("Paula","ADJE","pauladje@gmail.com");

        //Save students
        System.out.println("Saving student");

        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
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
