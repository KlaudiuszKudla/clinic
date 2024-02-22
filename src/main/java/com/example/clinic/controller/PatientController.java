package com.example.clinic.controller;

import com.example.clinic.entity.patient.Patient;
import com.example.clinic.entity.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "api/v1/patient")
public class PatientController {

    private final PatienService patienService;

    @GetMapping
    public ResponseEntity<Patient> getPatient(){
        return null;
    }

    @PostMapping
    public ResponseEntity<Response> addPatient(@RequestBody PatientRequest patientRequest){

    }
}
