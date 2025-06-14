package com.home.practice.spring_reviewv2_jpa.handler;

import com.home.practice.spring_reviewv2_jpa.exception.MemberNotFoundException;
import com.home.practice.spring_reviewv2_jpa.exception.MemberValidException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class globalHandlerException {

    @ExceptionHandler(MemberNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String MemberNotFound(MemberNotFoundException e){
        return e.getMessage();
    }

    @ExceptionHandler(MemberValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String MemberValid(MemberValidException e){
        return e.getMessage();
    }
}
