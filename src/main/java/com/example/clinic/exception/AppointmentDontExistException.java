package com.example.clinic.exception;

public class AppointmentDontExistException extends RuntimeException{
    public AppointmentDontExistException() {
        super();
    }

    public AppointmentDontExistException(String message) {
        super(message);
    }

    public AppointmentDontExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
