package com.example.clinic.exception;

public class AppointmentDontExistByIsFreeWithDoctorId extends RuntimeException{
    public AppointmentDontExistByIsFreeWithDoctorId(String message) {
        super(message);
    }

    public AppointmentDontExistByIsFreeWithDoctorId(String message, Throwable cause) {
        super(message, cause);
    }

    public AppointmentDontExistByIsFreeWithDoctorId(Throwable cause) {
        super(cause);
    }
}
