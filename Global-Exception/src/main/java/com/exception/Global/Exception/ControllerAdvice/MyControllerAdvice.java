package com.exception.Global.Exception.ControllerAdvice;

import com.exception.Global.Exception.GlobalException.EmptyInputException;
import com.exception.Global.Exception.GlobalException.ListNotPresentException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException) {
        return new ResponseEntity<String>("Input fields are empty, Please look into it", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ListNotPresentException.class)
    public ResponseEntity<String> handleListNotPresentException(ListNotPresentException listNotPresentException) {
        return new ResponseEntity<String>("List completely empty, we have nothing to return", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElement(NoSuchElementException noSuchElementException) {
        return new ResponseEntity<String>("No value is present in Database , Please Change the request ID", HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>("Please change your http media request", HttpStatus.METHOD_NOT_ALLOWED);
        //  return super.handleHttpRequestMethodNotSupported(ex, headers, status, request);
    }
}



