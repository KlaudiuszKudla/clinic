package com.example.clinic.exception;

public class OfficeDontExistException extends RuntimeException{

    public OfficeDontExistException(String message) {
        super(message);
    }

    public OfficeDontExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public OfficeDontExistException(Throwable cause) {
        super(cause);
    }
}
