package com.example.clinic.exception;

import com.example.clinic.entity.response.Code;
import com.example.clinic.entity.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DoctorDontExistException.class)
    public ResponseEntity<Response> handleDoctorDontExistException(DoctorDontExistException ex, WebRequest request){
        Response response = new Response(Code.DOCTOR_NOT_EXIST);
        return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AppointmentDontExistException.class)
    public ResponseEntity<Response> handleAppointmentDontExistException(AppointmentDontExistException ex, WebRequest request){
        Response response = new Response(Code.APPOINTMENT_NOT_EXIST);
        return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
    }


}
