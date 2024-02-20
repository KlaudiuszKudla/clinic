package com.example.clinic.exception;

public class DoctorDontExistException extends Exception{
    public DoctorDontExistException(String message) {
        super(message);
    }

    public DoctorDontExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public DoctorDontExistException(Throwable cause) {
        super(cause);
    }
}
