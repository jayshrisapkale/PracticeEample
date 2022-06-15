package com.example.employee.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class EmployeeControllerAdvice {

    @ExceptionHandler(ExceptionResponse.class)
    public ResponseEntity<String> handleResponse(ExceptionResponse exceptionResponse){
        return  new ResponseEntity<String> ("inpute field are empty", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleResponseNoSuchElementException(NoSuchElementException noSuchElementException){
        return  new ResponseEntity<String> ("no value present in db", HttpStatus.NOT_FOUND);
    }
}
