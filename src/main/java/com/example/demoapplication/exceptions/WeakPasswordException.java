package com.example.demoapplication.exceptions;

public class WeakPasswordException extends RuntimeException{
    public WeakPasswordException(String msg){
        super(msg);
    }
}
