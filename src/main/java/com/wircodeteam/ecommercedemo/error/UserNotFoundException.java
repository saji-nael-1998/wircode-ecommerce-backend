package com.wircodeteam.ecommercedemo.error;

public  class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String id) {
        super(String.format("%s is not found!",id));
    }
}