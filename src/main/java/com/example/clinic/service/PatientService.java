package com.example.clinic.service;

import com.example.clinic.entity.patient.Patient;
import com.example.clinic.entity.patient.PatientCreator;
import com.example.clinic.entity.response.Code;
import com.example.clinic.entity.response.Response;
import com.example.clinic.exception.PatientDontExistException;
import com.example.clinic.mapper.PatientMapper;
import com.example.clinic.repository.PatientRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;


    public ResponseEntity<Response> addPatient(PatientCreator patientCreator) {
        Patient patient = patientMapper.PatientCreatorToPatient(patientCreator);
        this.patientRepository.saveAndFlush(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response(Code.PATIENT_CREATED));
    }

    public ResponseEntity<Patient> getPatientById(Long patientId) {
        Patient patient = this.patientRepository.findById(patientId).
                orElseThrow(() -> new PatientDontExistException("Patient dont exist"));
        return  ResponseEntity.ok(patient);
    }
}
