package com.threesum.assignment.exception;

public class UserServiceException extends RuntimeException{
    private static final long serialVersionUID = 1;
    public UserServiceException(String message){
        super(message);
    }
}
