package com.luv2code.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


//this makes the exception handler available to the entire application
@ControllerAdvice
public class StudentRestExceptionHandler {
    //add exception handling code her
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        //return response entity

        return new
                ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
