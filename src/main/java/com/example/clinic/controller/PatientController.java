package com.example.clinic.controller;

import com.example.clinic.entity.Patient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "api/v1/patient")
public class PatientController {

    @GetMapping
    public ResponseEntity<Patient> getPatient(){
        return null;
    }
}
