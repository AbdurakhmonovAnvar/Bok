package com.team.Bok.exception;

public class BadRequest extends RuntimeException{
    public BadRequest(String message){
        super(message);
    }
}
