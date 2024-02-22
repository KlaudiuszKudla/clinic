package com.example.clinic.exception;

public class PatientDontExistException extends RuntimeException{

    public PatientDontExistException(String message) {
        super(message);
    }

    public PatientDontExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public PatientDontExistException(Throwable cause) {
        super(cause);
    }
}
