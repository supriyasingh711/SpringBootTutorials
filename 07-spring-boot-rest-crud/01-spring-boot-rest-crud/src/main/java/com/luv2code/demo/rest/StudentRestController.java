package com.luv2code.demo.rest;


import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;
    //define @PostConstruct to load the student data .. only once
    @PostConstruct
    public void loadData(){
         theStudents=new ArrayList<>();
        theStudents.add(new Student("Supriya","Singh"));
        theStudents.add(new Student("Suvam","Singh"));
        theStudents.add(new Student("Puja","Singh"));
    }

    //define endpoint for /students - return a list of students
    @GetMapping("/students")
    public List<Student>  getStudents(){

        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        //just index into the list... keep it simple for now
        //check the studentId again List size
        if((studentId)>=theStudents.size() || (studentId<0)) {
            throw new StudentNotFoundException("Student id not Found-"+studentId);
        }
        return theStudents.get(studentId
        );
    }
    //adding an exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        //create a studentErrorResponse
        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        //return response entity

        return new
                ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    //add another exception hanler

}
