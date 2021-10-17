package com.example.Login.exception;

public class UserNameNotFoundException extends RuntimeException {
    public UserNameNotFoundException(String details){
        super(details);
    }
}
