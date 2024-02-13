package com.example.clinic.exception;

public class DocktorDontExistException extends Exception{
    public DocktorDontExistException(String message) {
        super(message);
    }

    public DocktorDontExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public DocktorDontExistException(Throwable cause) {
        super(cause);
    }
}
