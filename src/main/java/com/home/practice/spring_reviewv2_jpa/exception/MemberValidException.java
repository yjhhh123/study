package com.home.practice.spring_reviewv2_jpa.exception;

public class MemberValidException extends RuntimeException {
    public MemberValidException(String message) {
        super(message);
    }
}
