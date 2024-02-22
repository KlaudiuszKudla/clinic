package com.example.clinic.controller;

import com.example.clinic.entity.patient.Patient;
import com.example.clinic.entity.patient.PatientCreator;
import com.example.clinic.entity.response.Response;
import com.example.clinic.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/v1/patient")
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<Patient> getPatientById(@RequestParam Long patientId){
        return this.patientService.getPatientById(patientId);
    }

    @PostMapping
    public ResponseEntity<Response> addPatient(@RequestBody PatientCreator patientCreator){
        return this.patientService.addPatient(patientCreator);
    }
}
